package com.clearprecision.curry

object Currying {
  def main(args: Array[String]) {

    def func = (a: Int, b: Int) => (a + b) * 10.52312
    curry(func)

  }

  /**
   * Currying Exercise
   */
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }
}