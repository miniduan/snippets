package com.clearprecision.parser

import akka.testkit.TestActorRef
import org.junit.runner.RunWith
import org.junit.Test
import akka.testkit.TestKit
import akka.actor.ActorSystem
import akka.testkit.ImplicitSender
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers

@Test
class ParserActorTest extends TestKit(ActorSystem("testActorSystem")) with ImplicitSender
  with WordSpec
  with MustMatchers {

  "A simple actor" must {
    "send back a result" in {
      // Creation of the TestActorRef
      val actorRef = TestActorRef[ParserActor]
      actorRef ! "akka"
      // 	This method assert that the `testActor` has received a specific message
      expectMsg("Hello akka")
    }
  }

}