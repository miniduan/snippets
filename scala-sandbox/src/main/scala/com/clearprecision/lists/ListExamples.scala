package com.clearprecision.lists

import scala.annotation.tailrec

object ListExamples extends App {

  val intList = List(1, 2, 3, 4, 5)

  val ints = for (i <- 1 to 900000) yield i

  def listComprehension() = {
    val newList = for (x <- intList; if x > 2) yield x
    newList
  }

  def paralellList() = {
    var start = System.currentTimeMillis()
    val result = intList.map(el => el * el)
    val stTime = System.currentTimeMillis() - start

    start = System.currentTimeMillis()
    val parResul = intList.par.map(el => el * el)
    val mtTime = System.currentTimeMillis() - start
    (stTime, mtTime)

  }

  @tailrec
  def factorial(data: List[Int], accum: Int): Int = {
    if (data == Nil) {
      return accum
    } else {
      factorial(data.tail, data.head * 2)
    }
  }

  println(listComprehension)

  val res = paralellList
  println("Single threaded operation took " + res._1)
  println("Multi threaded threaded operation took " + res._2)

  println(factorial(intList, 0))

}