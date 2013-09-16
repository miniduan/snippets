package com.clearprecision.serializer

import java.util.Date
import scala.xml.Attribute
import scala.xml.Text
import scala.xml.Null
import scala.collection.mutable.ArrayBuffer

class MeasData(elementType: String, userLabel: String, prefix: String, localDn: String, beginTime: Date, endTime: Date) extends MetaData {


  def fromXml(node:scala.xml.Node) = {

    val data = node \ "measData" \ "measInfo" \ "measValue"
    data.foreach()

    val types = (node \ "measData" \ "measInfo" \ "measTypes").text


    val names = for {
      measurement <- types.split(" ")
    } yield measurement


  }


  def toXml = {

    val header = new FileHeader(prefix, localDn, elementType, beginTime)
    val footer = new FileFooter(endTime)

    <measCollecFile xmlns="http://www.3gpp.org/ftp/specs/archive/32_series/32.435#measCollec" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.3gpp.org/ftp/specs/archive/32_series/32.435#measCollec http://www.3gpp.org/ftp/specs/archive/32_series/32.435#measCollec">
      { header.toXml }
      <measData>
        {
          val manageElement = <managedElement/> % Attribute(None, "localDn", Text(localDn), Null) % Attribute(None, "userLable", Text(userLabel), Null)
          manageElement
        }
        <measInfo>
          <job jobId="1231"/>
          {
            val granP = <granPeriod duration="PT900S"/> % Attribute(None, "endTime", Text(timeformat(endTime)), Null)
            granP
          }
          <repPeriod duration="PT1800S"/>
          <measTypes>
            attTCHSeizures succTCHSeizures attImmediateAssignProcs
				succImmediateAssignProcs
          </measTypes>
          <measValue measObjLdn="RncFunction=RF-1,UtranCell=Gbg-997">
            <measResults>234 345 567 789</measResults>
          </measValue>
          <measValue measObjLdn="RncFunction=RF-1,UtranCell=Gbg-998">
            <measResults>890 901 123 234</measResults>
          </measValue>
          <measValue measObjLdn="RncFunction=RF-1,UtranCell=Gbg-999">
            <measResults>456 567 678 789</measResults>
            <suspect>true</suspect>
          </measValue>
        </measInfo>
      </measData>
      { footer.toXml }
    </measCollecFile>

  }

}