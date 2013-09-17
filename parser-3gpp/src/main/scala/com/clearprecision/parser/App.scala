package com.clearprecision.parser

import java.util.Date
import java.util.Calendar
import com.clearprecision.serializer._
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.routing.RoundRobinRouter
import com.clearprecision.data.DataStorageActor
import org.slf4j.LoggerFactory
import akka.actor.Actor
import com.clearprecision.parser.messages.ParseResult
import scala.collection.JavaConversions
import java.io.File
import com.clearprecision.parser.messages.ParseRequest
import com.clearprecision.parser.messages.Stop
import com.clearprecision.parser.messages.Start

object App extends Application {

  override def main(args: Array[String]) {
    println("Starting...")
    val system = ActorSystem("3gpp-parser-system")

    for (ln <- io.Source.stdin.getLines) {
      ln match {
        case "Start" => {
          val control = system.actorOf(Props[ControlActor], "controller")
          control ! Start
          start(control)          
        }
        case "Stop" => {
          println("Stop message sent")
          system.actorSelection("akka://parser-3gpp/user/controller") ! Stop          
        }
        case _ => println("Supported commands are Start and Stop");
      }
    }

  }

  def start(control: ActorRef) = {
    println("Starting to send files to system")
    val files = new File("/var/tmp/data").listFiles
    files.foreach(file => control ! ParseRequest(file.getAbsolutePath))
  }

}
