package com.clearprecision.akka

import akka.actor.ActorSystem
import akka.actor.ActorContext
import akka.actor.Props
import com.clearprecision.akka.messages.Request
import com.clearprecision.akka.messages.TaskRequest
import akka.actor.Actor
import com.clearprecision.akka.messages.Response
import com.clearprecision.akka.messages.Stop
import com.clearprecision.akka.messages.Start
import com.clearprecision.akka.messages.Start
import com.clearprecision.akka.messages.TaskRequest


/**
 * Hello world!
 *
 */
object App extends Application {

  val data:List[Int] = List(1,2,3,4,5,6)
  val request = new TaskRequest(data)
  val start = new Start

  val system = ActorSystem("appActorSystem")
  val sender = system.actorOf(Props[WorkManager], "sender")  
  
  var i=0
  for(i <- 0 until 200) {
    val calc = i :: data  
    println("sending request for "+calc)
    sender ! TaskRequest(calc)
  }
  
  
}
