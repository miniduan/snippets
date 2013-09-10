package com.clearprecision.akka

import akka.actor.Actor
import com.clearprecision.akka.messages.TaskRequest
import com.clearprecision.akka.messages.TaskRequest
import com.clearprecision.akka.messages.Response
import akka.actor.Props
import com.clearprecision.akka.messages.Stop
import com.clearprecision.akka.messages.Response
import com.clearprecision.akka.messages.TaskRequest

class WorkManager extends Actor {

  val processor = context.actorOf(Props[Processor], "processor")

  override def preStart = {
    println("Starting WorkManager")
  }

  def receive = {
    case TaskRequest(x) => {
      println("Work Manager recived " + x + "  to forward to processor")
      processor ! TaskRequest(x)
    }

    case Stop => context.stop(self)

    case Response(message) => {
      println("Received response " + message)
    }

    case _ => println("Work manager received unknown event ")
  }
}