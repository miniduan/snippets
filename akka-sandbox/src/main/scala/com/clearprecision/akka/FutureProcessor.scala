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
  
  val future = Future {    
    val result = compositeList.foreach(list => println(list.sum))
    
    
  }
  
  
  future    

}