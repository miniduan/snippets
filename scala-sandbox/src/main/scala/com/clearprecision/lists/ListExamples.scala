package com.clearprecision.lists

object ListExamples extends App {

  val intList = List(1, 2, 3, 4, 5)
  
  val ints = for (i <-1 to 1000) yield i
  

  def listComprehension() = {
    val newList = for (x <- intList; if x > 2) yield x
    newList
  }

  def paralellList() = {
    var start = System.currentTimeMillis()
    val result = intList.map(el => el * el)
    val stTime = System.currentTimeMillis()-start
    
    start = System.currentTimeMillis()
    val parResul = intList.par.map(el => el * el)
    val mtTime = System.currentTimeMillis()-start
    (stTime, mtTime)
    
  }

  print(listComprehension)
  
  val res = paralellList
  print("Single threaded operation took "+res._1)
  print("Multi threaded threaded operation took "+res._2)
  

}