package com.clearprecision.parser

import akka.actor.Actor
import com.clearprecision.parser.messages._

/**
 * Created with IntelliJ IDEA.
 * User: tony
 * Date: 16/09/13
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
class ParserActor extends Actor {

  def receive: Actor.Receive = {
    case Parse(filePath) => {
      val node = xml.XML.loadFile(filePath)



      sender ! ParseResult("Parsing of file completed", true, file)

    }
    case _ => println("Uknown message received by parser actor")
  }
}
