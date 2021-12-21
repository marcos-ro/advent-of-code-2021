package com.github.marcosro.aoc21.models.cli.linux

private object PromptLinux:
  def readLn(text: String): String =
    print(text)
    scala.io.StdIn.readLine()

  def newLine: Unit =
    println()
