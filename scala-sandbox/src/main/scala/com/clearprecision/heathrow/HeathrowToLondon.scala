package com.clearprecision.heathrow

import scala.io.Source
import scala.collection.mutable.ArrayBuffer

object HeathrowToLondon {

  def main(args: Array[String]): Unit = {
    val buffer = ArrayBuffer[Int]()
    Source.fromFile("src/test/resources/road.txt").getLines.foreach(line => buffer += line.toInt)
    val roadData = buffer.toList
    val list = List()
    val routeData = createRouteData(roadData, list)

    //routeData.foldLeft(z)(f)

  }

  def shortestPath(pathA: Tuple3[Int, Int, Int], pathB: Tuple3[Int, Int, Int], result: Tuple3[Int, Int, Int]) = {
	  pathA._1 + pathA._3
  }

  def createRouteData(roadData: List[Int], listOfTuple: List[Tuple3[Int, Int, Int]]): List[Tuple3[Int, Int, Int]] = {
    if (roadData.length < 3) {
      listOfTuple
    } else {
      val headThree = roadData.take(3)
      val tupl = (headThree(0), headThree(1), headThree(2))
      val result = listOfTuple :+ tupl
      createRouteData(roadData.drop(3), result)
    }
  }

}