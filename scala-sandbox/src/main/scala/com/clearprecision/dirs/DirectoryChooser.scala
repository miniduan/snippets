package com.clearprecision.dirs

import java.io.File
import scala.collection.immutable.List

class DirectoryChooser {

  val directories = List("dir1", "dir2")
  val maxSize: Int = 10000
  
  
  def initBuffer() = {
    
  }
  

  /**
   * Creates symlinks 
   */
  def createSymLinks(symlinkTargets: List[String], outputDirectory:String) = {
    val result = symlinkTargets.map(dir => processDirectory(dir))
    println(result)
    
    result.foreach(value => value._1)
  }

  /**
   * Processes the given directory to calculate the current number of files it contains, how many more files it can hold.
   * Function returns a type containing (File, current size, space remaining)
   */
  private def processDirectory(dir: String): Tuple3[String, Int, Int] = {
    val file = new File(dir)
    println(file)
    val size = file.list.length
    val spaceRemaining = maxSize - size
    (dir, size, spaceRemaining)
  }

}