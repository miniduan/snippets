package com.clearprecision.akka

import akka.actor.Actor
import com.clearprecision.akka.messages.Request

class Processor extends Actor {

  def receive = {
    case Request(msg) => println(msg)
    case _ => println("stopping Processor actor"); context.stop(self)
  }
  
}