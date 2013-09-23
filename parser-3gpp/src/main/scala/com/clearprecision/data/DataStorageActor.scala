package com.clearprecision.data

import akka.actor.Actor
import com.clearprecision.parser.messages.ParseResult
import akka.actor.ActorLogging
import scala.collection.JavaConversions._

class DataStorageActor extends Actor with ActorLogging {
  
  val dataMgr = new CassandraDataAccess("localhost")

  def receive = {
    case ParseResult(_, _, _, measurementData) => {
      dataMgr.save(measurementData)
      log.debug(measurementData.toString())
      log.debug(measurementData.getFileHeader.getVendorName)
      log.debug(measurementData.getFileHeader.getDnPrefix)
    }
    case _ => log.error("Ignoring unkown data received by DataStorageActor")
  }

  override def postStop() = {
    log.info("postStop called on DataStorageActor")
  }

}