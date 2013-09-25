package com.clearprecision.cake

class DataService(env: { val db: DataAccess }) {

  def createAndSaveSomeData() = {
    env.db.save(new DataModel(1, "A simple test", "a simple value"))
  }
  
  
  def getSomeData(model:DataModel):DataModel = {
    env.db.get(model)
  }

}