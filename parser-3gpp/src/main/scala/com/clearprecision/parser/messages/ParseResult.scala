package com.clearprecision.parser.messages

/**
 * Created with IntelliJ IDEA.
 * User: tony
 * Date: 16/09/13
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
sealed case class ParseResult(message:String, error:Boolean, filePath:String) {

}
