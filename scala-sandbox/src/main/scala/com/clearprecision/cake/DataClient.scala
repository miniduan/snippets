package com.clearprecision.cake

class DataClient(env: { val service: DataService }) {

  def doSomething() = {
    env.service.createAndSaveSomeData
  }

  def getDataModel(): DataModel = {
    val query = new DataModel(1, "", "")
    env.service.getSomeData(query)
  }

}