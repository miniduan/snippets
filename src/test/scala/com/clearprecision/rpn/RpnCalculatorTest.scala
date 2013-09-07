package com.clearprecision.rpn

import org.junit._
import Assert._

@Test
class AppTest {

  @Test
  def addition() = {
    val result = RpnCalculator.calculate("10 4 +")
    assertEquals(14, result)
  }

  @Test
  def subtraction() = {
    val result = RpnCalculator.calculate("10 4 -")
    assertEquals(-6, result)
  }

  @Test
  def multiplication() = {
    val result = RpnCalculator.calculate("10 4 *")
    assertEquals(40, result)
  }

  @Test
  def division() = {
    val result = RpnCalculator.calculate("4 40 /")
    assertEquals(10, result)
  }

}


