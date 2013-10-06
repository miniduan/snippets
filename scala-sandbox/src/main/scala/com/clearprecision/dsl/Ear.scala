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

/*

class Money(val amount: BigDecimal) {

  def + (m: Money)  =
      Money(amount.bigDecimal.add(m.amount.bigDecimal))
  def - (m: Money)  =
      Money(amount.bigDecimal.subtract(m.amount.bigDecimal))
  def * (m: Money)  =
      Money(amount.bigDecimal.multiply(m.amount.bigDecimal))
  def / (m: Money)  =
      Money(amount.bigDecimal.divide(m.amount.bigDecimal,
          Money.scale, Money.jroundingMode))

  def <  (m: Money)  = amount <  m.amount
  def <= (m: Money)  = amount <= m.amount
  def >  (m: Money)  = amount >  m.amount
  def >= (m: Money)  = amount >= m.amount

  override def equals (o: Any) = o match {
    case m: Money => amount equals m.amount
    case _ => false
  }

  override def hashCode = amount.hashCode * 31

  // Hack: Must explicitly call the correct conversion: double2Double
  override def toString =
      String.format("$%.2f", double2Double(amount.doubleValue))
}

object Money {
  def apply(amount: BigDecimal)  = new Money(amount)
  def apply(amount: JBigDecimal) = new Money(scaled(new BigDecimal(amount)))
  def apply(amount: Double)      = new Money(scaled(BigDecimal(amount)))
  def apply(amount: Long)        = new Money(scaled(BigDecimal(amount)))
  def apply(amount: Int)         = new Money(scaled(BigDecimal(amount)))

  def unapply(m: Money) = Some(m.amount)

  protected def scaled(d: BigDecimal) = d.setScale(scale, roundingMode)

  val scale = 4
  val jroundingMode = JRoundingMode.HALF_UP
  val roundingMode  = BigDecimal.RoundingMode.ROUND_HALF_UP
  val context = new JMathContext(scale, jroundingMode)*/

