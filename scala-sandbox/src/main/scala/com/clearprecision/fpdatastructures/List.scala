package com.clearprecision.fpdatastructures

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(_, t) => t
  }

  def setHead[A](head: A, as: List[A]): List[A] = as match {
    case Nil => apply(head)
    case Cons(_, _) => Cons(head, as)
  }

  def drop[A](l: List[A], n: Int): List[A] = {

    @tailrec
    def loop(start: Int, currentList: List[A]): List[A] = {
      if (start == n) currentList
      else loop(start + 1, tail(currentList))
    }
    
    loop(0, l)
  }

}

