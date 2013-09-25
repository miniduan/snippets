package com.clearprecision.cake

trait DataAccess {
  
  def save(model:DataModel):Unit
  
  def get(model:DataModel):DataModel

}