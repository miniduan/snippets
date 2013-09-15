package com.clearprecision.serializer

import scala.xml.Attribute
import scala.xml.Text
import scala.xml.Null
import java.util.Date
import com.clearprecision.serializer.MetaData

class FileHeader(prefix: String, localDn: String, elementType: String, beginTime: Date) extends MetaData {

  def toXml = {

    val fileHeader = <fileSender/> % Attribute(None, "localDn", Text(localDn), Null) % Attribute(None, "elementType", Text(elementType), Null)
    val meas = <measCollec/> % Attribute(None, "beginTime", Text(timeformat(beginTime)), Null)
    <fileHeader>
      {fileHeader}
    
      {meas}
    </fileHeader> % Attribute(None, "fileFormatVersion", Text(fileFormatVersion), Null) % Attribute(None, "vendorName", Text(vendorName), Null) % Attribute(None, "dnPrefix", Text(prefix), Null)

  }

}