package com.clearprecision.serializer

import java.util.Date

import scala.xml.Attribute
import scala.xml.Null
import scala.xml.Text


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