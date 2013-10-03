package com.clearprecision.akka.messages

sealed trait State {

}

case object Stopped extends State

case object Running extends State


sealed trait Data

case object RequestData extends Data
case object ResponseData extends Data