package com.clearprecision.traits

import scala.collection.mutable.ArrayBuffer

class TraitsExpierments extends App {

  val list = new ArrayBuffer[Int] with Noisy
  list :+ 1
  list :+ 2
  
  list.foreach(e => println(e))

  list.makeNoise

}