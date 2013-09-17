package com.clearprecision.parser

import akka.actor.Actor
import com.clearprecision.parser.messages._
import com.clearprecision.parser.messages.Parse
import scala.xml.pull.XMLEventReader
import scala.io.Source
import scala.xml.pull.EvElemStart
import scala.xml.pull.EvElemEnd
import scala.xml.pull.EvText
import akka.actor.ActorLogging


class ParserActor extends Actor with ActorLogging {

  override def postStop() = {
    log.info("postStop called on ParserActor")
  }

  def receive: Actor.Receive = {
    case Parse(filePath) => {
      log.debug("ParseActor received parse request for "+filePath)
      val parser = new MeasurementParser(filePath)
      val result = parser.parse
      if (result != null) {
        sender ! ParseResult("Parsing of file completed", true, filePath, result)
      } else {
        sender ! ParseResult("Parsing of file failed", false, filePath, result)
      }
    }
    case _ => log.info("Uknown message received by parser actor")
  }

}
