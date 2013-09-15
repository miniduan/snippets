package com.clearprecision.akka

import akka.actor.Actor
import com.clearprecision.akka.messages._

class Processor extends Actor {

  override def preStart = {
    println("Starting processor")
  }

  def receive = {    
    case TaskRequest(data) => {           
      val result = data.sum
      sender ! Response("Result was " + result)
    } 
    case x => println("Processor received a "+x.getClass.toString)
  }

}