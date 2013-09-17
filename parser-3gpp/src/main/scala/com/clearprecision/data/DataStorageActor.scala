package com.clearprecision.data

import akka.actor.Actor
import com.clearprecision.parser.messages.ParseResult
import org.slf4j.LoggerFactory

class DataStorageActor extends Actor {

  val logger = LoggerFactory.getLogger("DataStorageActor");

  def receive = {
    case ParseResult(_, _, _, measurementData) => {
      logger.debug(measurementData.toString())
    }
    case _ => logger.error("Ignoring unkown data received by DataStorageActor")
  }

  override def postStop() = {
    logger.info("postStop called on DataStorageActor")
  }

}