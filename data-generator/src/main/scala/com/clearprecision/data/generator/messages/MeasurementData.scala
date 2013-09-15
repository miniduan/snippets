package com.clearprecision.data.generator.messages

import java.util.Date

sealed case class MeasurementData(fdn:String, startTime:Date, endTime:Date) {

}