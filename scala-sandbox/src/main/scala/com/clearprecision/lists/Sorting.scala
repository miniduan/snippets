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
    for (i <- 1 until as.length) {
      if (gt(as(i), as(i - 1)) == false)
        return false
    }
    true
  }

}