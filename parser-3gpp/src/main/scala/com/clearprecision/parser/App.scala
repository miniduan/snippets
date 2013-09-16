package com.clearprecision.parser

import java.util.Date
import java.util.Calendar
import com.clearprecision.serializer._

/**
 * Hello world!
 *
 */
object App extends Application {
  
  val now = new Date()
  val end = new Date(System.currentTimeMillis()+15*60*1000)
  
  val measurement = new MeasData("RNC", "rnc1", "FDN=1", "FDN=1;ManageElement=1", now, end)

  println(measurement.toXml)


  
}
