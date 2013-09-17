package com.clearprecision.parser.messages

import com.clearprecision.parser.jaxb.MeasCollecFile

sealed case class ParseResult(message: String, error: Boolean, filePath: String, parsedObject: MeasCollecFile) {

}
