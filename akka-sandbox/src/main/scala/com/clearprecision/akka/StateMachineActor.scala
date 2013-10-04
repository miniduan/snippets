package com.clearprecision.akka

import akka.actor.Actor
import akka.actor.FSM
import scala.concurrent.duration._

import com.clearprecision.akka.messages._

class StateMachineActor extends Actor with FSM[State, Data] {

  startWith(Stopped, RequestData)

  when(Running, stateTimeout = 1 second) {
    case _ => stay
  }

  initialize()

}