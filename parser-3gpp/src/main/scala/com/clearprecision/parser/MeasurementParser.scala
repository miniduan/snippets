package com.clearprecision.parser

import com.clearprecision.parser.api.MeasurementFactory
import com.clearprecision.parser.jaxb.MeasCollecFile

class MeasurementParser(file: String) {

  def parse(): MeasCollecFile = {
    return MeasurementFactory.build(file)    
  }

}