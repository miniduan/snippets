package com.clearprecision.akka.messages

sealed case class TaskRequest(data:List[Int]) extends Request {
  
}