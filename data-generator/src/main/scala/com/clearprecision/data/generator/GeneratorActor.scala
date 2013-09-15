package com.clearprecision.data.generator

import akka.actor.Actor
import com.clearprecision.data.generator.messages.MeasurementData
import com.clearprecision.serializer.MeasData
import java.nio.file.Paths

class GeneratorActor extends Actor {

  override def receive = {
    case MeasurementData(fdn, start, end, output) => {
      val measurement = new MeasData("RNC", "", "prefix", fdn, start, end)
      scala.xml.XML.save(output+""+fdn+"_"+end+"_3gpp.xml", measurement.toXml)
      
    }
    case _ => println("Unknown value received")
  }

}