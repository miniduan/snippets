package com.clearprecision.parser

import org.junit.Assert.assertEquals
import org.scalatest.WordSpec
import org.scalatest.junit.AssertionsForJUnit
import org.scalatest.matchers.MustMatchers
import com.clearprecision.parser.messages.Parse
import com.clearprecision.parser.messages.ParseResult
import akka.actor.ActorSystem
import akka.testkit.ImplicitSender
import akka.testkit.TestActorRef
import akka.testkit.TestKit
import org.scalatest.BeforeAndAfterAll

class ParserActorTest extends TestKit(ActorSystem("testActorSystem")) with ImplicitSender
  with WordSpec
  with MustMatchers with AssertionsForJUnit with BeforeAndAfterAll {

  override def afterAll {
    println("Stop actor system")
    TestKit.shutdownActorSystem(system)
  }

  "A parser actor" must {
    "successfully parse a file" in {
      val actorRef = TestActorRef[ParserActor]
      val testRequest = new Parse("src/test/resources/test-pm-file-1-3gpp.xml")
      actorRef ! testRequest
      val res = expectMsgClass(classOf[ParseResult])
      println(res.parsedObject)
    }
  }

  "A parser actor" must {
    "return an error when an unknown object is received" in {
      val actorRef = TestActorRef[ParserActor]
      actorRef ! "test"
      val response = expectMsgClass(classOf[ParseResult])
      assertEquals(response.error, true)
    }
  }

}