package com.github.marcosro.aoc21.models.cli.jdk

import scala.io.Source

private object FromFileJDK:
  def fromFile[A](path: String, processing: String => A): List[A] =
    Source.fromResource(path).getLines.map(processing).toList
