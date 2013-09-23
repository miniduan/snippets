package com.clearprecision.data
import com.clearprecision.parser.jaxb._

trait DataOperations {
  
  def save(data:MeasCollecFile)
  
  def load(data:MeasCollecFile)

}