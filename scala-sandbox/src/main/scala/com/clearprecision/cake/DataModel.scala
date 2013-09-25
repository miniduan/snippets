package com.clearprecision.cake

class DataModel(id: Long, name: String, someValue: String) {

  override def toString() = {
    id + ", " + name + ", " + someValue
  }

}