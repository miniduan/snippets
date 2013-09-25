package com.clearprecision.cake

object AppConfig extends App {
  lazy val db = new DataAccessImpl  
  lazy val service = new DataService(this) 
    
  val client = new DataClient(AppConfig)
  client.doSomething
  
  println(client.getDataModel)
  
}