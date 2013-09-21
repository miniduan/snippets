package com.clearprecision.data

import com.clearprecision.serializer.MeasData

trait DataOperations {
  
  def save(data:MeasData)
  
  def load(data:MeasData)

}