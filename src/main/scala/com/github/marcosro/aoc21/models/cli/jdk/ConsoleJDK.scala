package com.github.marcosro.aoc21.models.cli.jdk

private object ConsoleJDK:
  def readLn(text: String): String =
    print(text)
    scala.io.StdIn.readLine()

  def printLn(text: String): Unit =
    println(text)

  def newLine: Unit =
    println()
