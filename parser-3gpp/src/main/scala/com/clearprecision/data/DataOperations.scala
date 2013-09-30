package com.clearprecision.data
import com.clearprecision.parser.jaxb._

/**
 * Data operations for 3GPP XML
 */
trait DataOperations {

  /**
   * Saves measurement data to a data store
   *
   * @param MeasCollecFile is a JAXB representation of the 3GPP PM xml schema
   */
  def save(data: MeasCollecFile):Unit

}