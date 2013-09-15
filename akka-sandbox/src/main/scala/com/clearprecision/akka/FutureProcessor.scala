package com.clearprecision.akka

import akka.actor.Actor
import com.clearprecision.akka.messages.TaskRequest

class FutureProcessor extends Actor {

  def receive = {
    case TaskRequest(x) => {      
    }
  }
  
}