package com.clearprecision.serializer

import java.util.Date
import scala.xml.Attribute
import scala.xml.Text
import scala.xml.Null
import com.clearprecision.serializer.MetaData

class FileFooter(endTime: Date) extends MetaData {

  def toXml = {
        
    val myXml = <measCollec/> % Attribute(None, "endTime", Text(timeformat(endTime)), Null)
    
    <fileFooter>
      {myXml}
    </fileFooter>
  }

}