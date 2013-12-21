package com.clearprecision.akka

import akka.actor.Actor
import com.clearprecision.akka.messages.TaskRequest
import scala.concurrent._
import scala.collection.immutable.List
import ExecutionContext.Implicits.global
import scala.concurrent.duration._


class FutureProcessor extends Application {

  val intList = List(1, 2, 3, 4, 5)
  val intList2 = List(10, 20, 30, 40, 50)
  val combinedList = List(intList, intList2)

  val result = Future {
    
    combinedList.foreach(element => {
      val intermediate = Future {
        element.sum
      }      
    })
  }

  result foreach println

}