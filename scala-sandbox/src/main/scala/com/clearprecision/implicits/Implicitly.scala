package com.clearprecision.implicits

object Implicitly {

  /**
   * Convert node version string to integer representation
   */
  implicit def stringVersionToInteger(version: String): Int = {
    version match {
      case "10A" => 1
      case "10B" => 2
      case "11A" => 3
      case "11B" => 4
      case "12A" => 5
      case "12B" => 6
    }
  }

  def main(args: Array[String]) {
    val nodeVersion = "10A"

    if (nodeVersion > 4) {
      println("node version is greater than 11B")
    }
  }

}