package com.clearprecision.fpdatastructures

object ListTest {

  def main(args: Array[String]) {
    val x = List(1, 2, 3,56,7,8,9,9)
    val res = List.tail(x)
    println(res)
    
    val dropped = List.drop(x, 3)
    println(dropped)
    
  }

}