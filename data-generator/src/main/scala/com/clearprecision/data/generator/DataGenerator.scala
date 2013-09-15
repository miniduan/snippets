package com.clearprecision.data.generator

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.routing.RoundRobinRouter
import com.clearprecision.data.generator.messages.MeasurementData
import java.util.Date
import akka.actor.PoisonPill
import scala.collection.mutable.ArrayBuffer
import akka.routing.Broadcast

object DataGenerator extends Application {

  val system = ActorSystem("mysystem")

  val actor1 = system.actorOf(Props[GeneratorActor])
  val actor2 = system.actorOf(Props[GeneratorActor])
  val actor3 = system.actorOf(Props[GeneratorActor])
  val routees = Vector[ActorRef](actor1, actor2, actor3)

  val router = system.actorOf(Props.empty.withRouter(
    RoundRobinRouter(routees = routees)))

  val fdns = DataGenerator.createFdns

  fdns.foreach(fdn => {
    val data = new MeasurementData(fdn, new Date(), new Date(System.currentTimeMillis() + 15 * 1000 * 60))
    router ! data
  })

  router ! Broadcast(PoisonPill)
  
  Thread.sleep(10000)
  
  System.exit(0)

  
  def createFdns(): Set[String] = {
    val buffer = ArrayBuffer[String]()
    
    for (i <- 1 until 1000) {
      buffer += "fdn=" + i
    }
    
    buffer.toSet
  }

}
