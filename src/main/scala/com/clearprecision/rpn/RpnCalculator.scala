package com.clearprecision.rpn

import scala.collection.mutable.Stack

object RpnCalculator extends Application {

  val Mult: String = "*"
  val Plus: String = "+"
  val Minus: String = "-"
  val Divide: String = "/"

  def calculate(rpnCalculation: String): Int = {
    def symbols = rpnCalculation.split(" ")
    val result = symbols.foldLeft(Stack[String]())((b, a) => rpn(b, a))
    result.pop.toInt
  }

  private def rpn(stack: Stack[String], item: String) = {
    item match {
      case Mult => stack.push((stack.pop.toInt * stack.pop.toInt).toString)
      case Plus => stack.push((stack.pop.toInt + stack.pop.toInt).toString)
      case Minus => stack.push((stack.pop.toInt - stack.pop.toInt).toString)
      case Divide => stack.push((stack.pop.toInt / stack.pop.toInt).toString)
      case _ => stack.push(item)
    }
    stack
  }

  override def main(args: Array[String]) {
    if (args.length != 1) {
      println("Usage: com.clearprecision.rpn.RpnCalculator <RPN>")
      println("Example: com.clearprecision.rpn.RpnCalculator 10 5 6 +")
    }
    println(RpnCalculator.calculate(args(0)))
  }

}
