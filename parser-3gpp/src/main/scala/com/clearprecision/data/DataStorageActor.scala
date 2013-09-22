package com.clearprecision.data

import akka.actor.Actor
import com.clearprecision.parser.messages.ParseResult
import akka.actor.ActorLogging
import scala.collection.JavaConversions._

class DataStorageActor extends Actor with ActorLogging{

  def receive = {
    case ParseResult(_, _, _, measurementData) => {
      log.debug(measurementData.toString())
      log.debug(measurementData.getFileHeader.getVendorName)
      log.debug(measurementData.getFileHeader.getDnPrefix)
      
      val data = measurementData.getMeasData
      data.foreach(measData => log.debug("Measedata "+measData))
            
    }
    case _ => log.error("Ignoring unkown data received by DataStorageActor")
  }

  override def postStop() = {
    log.info("postStop called on DataStorageActor")
  }

}