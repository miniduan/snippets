package com.clearprecision.parser

import akka.actor.Actor
import com.clearprecision.parser.messages._
import com.clearprecision.parser.messages.Parse
import scala.xml.pull.XMLEventReader
import scala.io.Source
import scala.xml.pull.EvElemStart
import scala.xml.pull.EvElemEnd
import scala.xml.pull.EvText
import org.slf4j.LoggerFactory

class ParserActor extends Actor {

  val logger = LoggerFactory.getLogger("ParserActor");

  override def postStop() = {
    logger.info("postStop called on ParserActor")
  }

  def receive: Actor.Receive = {
    case Parse(filePath) => {
      logger.debug("ParseActor received parse request for "+filePath)
      val parser = new MeasurementParser(filePath)
      val result = parser.parse
      if (result != null) {
        sender ! ParseResult("Parsing of file completed", true, filePath, result)
      } else {
        sender ! ParseResult("Parsing of file failed", false, filePath, result)
      }
    }
    case _ => logger.info("Uknown message received by parser actor")
  }

}
