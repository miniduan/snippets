package com.clearprecision.akka

import scala.collection.immutable.List
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import java.util.concurrent.Executors

class FutureProcessor extends Application {
    
  implicit val ec = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2))
  
  val data = List(1,2,3,4)
  val factors = List(10,20,30,40)
  val compositeList = List(data, factors)

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