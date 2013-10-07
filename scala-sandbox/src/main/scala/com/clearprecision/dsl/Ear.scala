package com.clearprecision.dsl

import scala.collection.immutable.Set

class Ear(val content: Set[Any]) {
  
  
  def +(element: Any): Ear = {
    println("adding class " + element)
    content + element
    Ear(content)
  }

}

object Ear {
  
  def apply(content: Set[Any]) = new Ear(content)
  def unapply(ear:Ear) = Some(ear.content)
  
}
