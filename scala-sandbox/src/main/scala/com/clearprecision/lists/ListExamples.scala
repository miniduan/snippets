package com.clearprecision.lists

object ListExamples extends App {

  val intList = List(1, 2, 3, 4, 5)

  def listComprehension() = {      
    val newList = for (x <- intList; if x > 2) yield x
    newList
  }
  
  listComprehension

}