package com.clearprecision.dirs

import java.nio.file.Files
import java.nio.file.Paths
import java.util.ArrayList
import java.nio.file.DirectoryStream
import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor

/**
 * Test helpers for generating and deleting data
 */
object TestDataGenerator {

  def createFiles(baseDirectory: String) = {
    var i = 0
    for (i <- 1 until 10000) {
      def path = Paths.get("src/test/resources/", baseDirectory, "file" + i + ".txt")
      Files.createFile(path)
    }
  }

  def createSymLinks(inputDirectory: String, outputDirectory: String) = {
    def inputFiles = TestDataGenerator.list(inputDirectory)
    inputFiles.foreach(file => Files.createLink(Paths.get(outputDirectory, file.getFileName.toString), file))
  }

  def list(directory: String): Set[Path] = {
    def fileNames = new ArrayBuffer[Path]
    val directoryStream = Files.newDirectoryStream(Paths.get(directory))
    directoryStream.foreach(path => fileNames.add(path))
    fileNames.toSet
  }

  def list(path: Path): Set[Path] = {
    list(path.toString())
  }

  def deleteRecursive(directory: String) = {
    Files.walkFileTree(Paths.get(directory), new DeleteFileVisitor)
  }
}