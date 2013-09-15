package com.clearprecision.data.generator

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.routing.RoundRobinRouter
import scala.concurrent.duration._
import com.clearprecision.data.generator.messages.MeasurementData
import java.util.Date
import akka.actor.PoisonPill
import scala.collection.mutable.ArrayBuffer
import akka.routing.Broadcast
import akka.actor.Actor
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit
import akka.io.TickGenerator.Tick
import scala.concurrent.duration.Duration
import org.slf4j.LoggerFactory

object DataGenerator extends Application {

  def logger = LoggerFactory.getLogger("DataGenerator");

  override def main(args: Array[String]) {
    if (args.length != 1) {
      println("Specify output directory")
      System.exit(1)
    }
    startRouting(args(0))
  }

  def startRouting(outputDir: String) = {

    logger.info("Starting data-generator actor system")
    val system = ActorSystem("data-generator")
    val actor1 = system.actorOf(Props[GeneratorActor])
    val actor2 = system.actorOf(Props[GeneratorActor])
    val actor3 = system.actorOf(Props[GeneratorActor])
    val actor4 = system.actorOf(Props[GeneratorActor])
    val actor5 = system.actorOf(Props[GeneratorActor])
    val routees = Vector[ActorRef](actor1, actor2, actor3, actor4, actor5)

    val router = system.actorOf(Props.empty.withRouter(
      RoundRobinRouter(routees = routees)))

    logger.info("Sending job messages for 3GPP XML generation")
    sendJobMessages(router, outputDir)

  }

  def sendJobMessages(router: ActorRef, outputDir: String) = {
    val fdns = createFdns
    fdns.foreach(fdn => {
      val data = new MeasurementData(fdn, new Date(), new Date(System.currentTimeMillis() + 15 * 1000 * 60), outputDir)
      router ! data
    })
    logger.info("Finished sending job messages")

  }

  def createFdns(): Set[String] = {
    val buffer = ArrayBuffer[String]()

    for (i <- 1 until 1000) {
      buffer += "fdn=" + i
    }

    buffer.toSet
  }

}
