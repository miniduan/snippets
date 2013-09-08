package com.clearprecision.dirs

import org.junit._
import Assert._
import scala.collection.mutable.ArrayBuffer


@Test
class DirectoryChooserTest {
  
  @Before
  def setup() = {
	  TestDataGenerator.createFiles("src/test/resources/testdata")
  }
  
  @After
  def cleanup() = {
    
  }

  @Test
  def testCount() = {
//    val chooser = new DirectoryChooser
//    
//    
//    val dirs = ArrayBuffer[String]() 
//    var i = 0
//    for(i <- 1 until 53) {
//      dirs += "/home/tony/git-projects/filestest/output/dir"+i 
//    }
//       
//    
//    val start = System.currentTimeMillis();
//    val result = chooser.createSymLinks(dirs.toList)
//    val end = System.currentTimeMillis();
//    
//    println (end - start)        
  }
}