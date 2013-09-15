package com.clearprecision.serializer

import java.util.Date

trait MetaData {
  
  protected def fileFormatVersion = "32.435 V7.0"

  protected def vendorName = "MyCompany"

  protected def timeformat(date: Date): String = {
    val formatter = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    formatter.format(date)
  }

}