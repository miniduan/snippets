package com.clearprecision.parser

import akka.testkit.TestKit
import akka.testkit.ImplicitSender
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.AssertionsForJUnit
import org.scalatest.WordSpec
import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.clearprecision.parser.messages._
import com.typesafe.config.ConfigFactory
import akka.testkit.EventFilter
import akka.actor.Props
import akka.actor.ActorKilledException
import akka.actor.Kill
import org.scalatest.BeforeAndAfterAll

class ControlActorTest extends TestKit(ActorSystem("testActorSystem")) with ImplicitSender
  with WordSpec
  with MustMatchers with AssertionsForJUnit with BeforeAndAfterAll {

  "A control actor actor" must {
    "successfully startup when a start message is received" in {
      val actorRef = TestActorRef[ControlActor]
      actorRef ! Start
    }

    "successfully stop when a stop message is received" in {
      val actorRef = TestActorRef[ControlActor]
      actorRef ! Stop
    }
  }

  "A parser actor" must {
    "successfully receive a request from the control actor to parse a file" in {
      val parserActorRef = TestActorRef[ParserActor]
      val controlActorRef = TestActorRef[ControlActor]
      val testRequest = new Parse("src/test/resources/test-pm-file-1-3gpp.xml")
      controlActorRef ! testRequest
      expectNoMsg
    }
  }

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

}