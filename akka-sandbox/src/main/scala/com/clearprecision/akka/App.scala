package com.clearprecision.akka

import akka.actor.ActorSystem
import akka.actor.ActorContext
import akka.actor.Props
import com.clearprecision.akka.messages.Request

/**
 * Hello world!
 *
 */
object App extends Application {

  val request = new Request("Hello")
  
  val actorSystem = ActorSystem("appSystem")
  val processor = actorSystem.actorOf(Props[Processor], "processor")

  processor ! request
  
  processor ! "shutdown"
  
  //exit

}
