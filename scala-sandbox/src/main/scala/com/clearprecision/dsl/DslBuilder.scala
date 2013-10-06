package com.clearprecision.dsl

object DslBuilder extends App {

  val clazz = classOf[String]
  
  val ear:Ear = Ear.apply(Set())
  ear + "Hello"
  
  ear.content.foreach(elem => println(elem))
    
}