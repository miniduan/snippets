package com.clearprecision.cake

class DataAccessImpl extends DataAccess {

  def save(model: DataModel) = {
	  println("Create model "+model)
  }

  def get(model: DataModel) = {
    val _model = new DataModel(1, "testModel", "testValue")
    _model
  }
}