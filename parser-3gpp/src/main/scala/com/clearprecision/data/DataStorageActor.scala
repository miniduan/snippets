package com.clearprecision.data

import akka.actor.Actor
import com.clearprecision.parser.messages.ParseResult
import akka.actor.ActorLogging

class DataStorageActor extends Actor with ActorLogging{

  def receive = {
    case ParseResult(_, _, _, measurementData) => {
      log.debug(measurementData.toString())
    }
    case _ => log.error("Ignoring unkown data received by DataStorageActor")
  }

  override def postStop() = {
    log.info("postStop called on DataStorageActor")
  }

}