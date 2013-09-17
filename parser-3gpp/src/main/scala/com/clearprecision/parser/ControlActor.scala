package com.clearprecision.parser

import akka.actor.Actor
import com.clearprecision.parser.messages.ParseResult
import akka.actor.Props
import com.clearprecision.data.DataStorageActor
import com.clearprecision.parser.messages.Start
import com.clearprecision.parser.messages.Stop
import org.slf4j.LoggerFactory
import akka.actor.ActorRef
import akka.routing.RoundRobinRouter
import akka.actor.ActorContext
import akka.actor.PoisonPill
import com.clearprecision.parser.messages.ParseRequest
import com.clearprecision.parser.messages.ParseRequest
import com.clearprecision.parser.messages.Parse

class ControlActor extends Actor {

  val logger = LoggerFactory.getLogger("ControlActor");
  val parserRouter: String = "akka://3gpp-parser-system/user/controller/parserRouter"
  val dataRouter: String = "akka://3gpp-parser-system/user/controller/dataRouter"

  def receive: Actor.Receive = {

    case Start => {
      logger.info("Control received start message")
      startDataActors()
      startParserActors()
    }

    case Stop => {
      logger.info("Control received stop message")
      context.actorSelection(parserRouter) ! PoisonPill
      context.actorSelection(dataRouter) ! PoisonPill
    }
    
    case ParseRequest(file) => {
      logger.debug("Control received parse request for "+file)
      context.actorSelection(parserRouter) ! Parse(file)
    }

    case ParseResult(message, true, filePath, measurementData) => {
      logger.debug("Control received succesful parse result for "+filePath)
      context.actorSelection(dataRouter) ! ParseResult(message, true, filePath, measurementData)
    }

    case ParseResult(message, false, filePath, _) => {
      logger.error("Error parsing file " + filePath)
    }

    case _ => println("Unknown message received")
  }

  private def startParserActors(): ActorRef = {
    logger.info("Starting parsing subsytem")
    val actor1 = context.actorOf(Props[ParserActor])
    val actor2 = context.actorOf(Props[ParserActor])
    val actor3 = context.actorOf(Props[ParserActor])
    val actor4 = context.actorOf(Props[ParserActor])
    val actor5 = context.actorOf(Props[ParserActor])
    val routees = Vector[ActorRef](actor1, actor2, actor3, actor4, actor5)

    context.actorOf(Props.empty.withRouter(RoundRobinRouter(routees = routees)), "parserRouter")
  }

  private def startDataActors(): ActorRef = {
    logger.info("Starting data storage subsytem")
    val actor1 = context.actorOf(Props[DataStorageActor])
    val actor2 = context.actorOf(Props[DataStorageActor])
    val actor3 = context.actorOf(Props[DataStorageActor])
    val actor4 = context.actorOf(Props[DataStorageActor])
    val actor5 = context.actorOf(Props[DataStorageActor])
    val routees = Vector[ActorRef](actor1, actor2, actor3, actor4, actor5)

    context.actorOf(Props.empty.withRouter(RoundRobinRouter(routees = routees)), "dataRouter")
  }

}
