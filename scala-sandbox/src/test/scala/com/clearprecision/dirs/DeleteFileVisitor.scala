package com.clearprecision.dirs

import java.nio.file.SimpleFileVisitor
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.io.IOException

class DeleteFileVisitor extends SimpleFileVisitor[Path] {

  override def visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult = {
    Files.delete(file);
    return FileVisitResult.CONTINUE;
  }

  override def visitFileFailed(file: Path, exc: IOException): FileVisitResult =
    {
      Files.delete(file);
      return FileVisitResult.CONTINUE;
    }

  override def postVisitDirectory(dir: Path, exc: IOException): FileVisitResult = {
    if (exc == null) {
      Files.delete(dir);
      return FileVisitResult.CONTINUE;
    } else {
      throw exc;
    }
  }
}