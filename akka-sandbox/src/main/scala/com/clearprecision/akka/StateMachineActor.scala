package com.clearprecision.akka

import akka.actor.Actor
import akka.actor.FSM

import com.clearprecision.akka.messages._

class StateMachineActor extends Actor with FSM[State, Data] {

  startWith(Stopped, RequestData)


  initialize()

}