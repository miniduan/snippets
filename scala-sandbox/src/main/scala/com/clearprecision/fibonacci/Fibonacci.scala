package com.clearprecision.fibonacci

import scala.annotation.tailrec

object Fibonacci {

  def main(args: Array[String]) {
	  println(fib(10))
  }

  def fib(n: Int): Int = {
    if (n < 2)
      return 1
    else {
      val a = fib(n - 1)
      val b = fib(n - 2)
      return (a + b)
    }
  }

}