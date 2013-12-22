package com.clearprecision.lists

object Sorting {

  def main(args: Array[String]) {

    val list1 = Array(1, 2, 3, 4, 5, 6)
    val list2 = Array(1, 2, 3, 4, 5, 6)

    def comparator = (a: Int, b: Int) => if (a > b) true else false

    println(isSorted(list1, comparator))
    println(isSorted(list2, comparator))

  }

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(i: Int, prev: A): Boolean = {
      if (i == as.length) true
      else if (gt(as(i), prev)) go(i + 1, as(i))
      else false
    }

    if (as.length == 0) true
    else go(1, as(0))
    true
  }

}