/**
 * Copyright(C) 2021 marcos-ro <marcosroropeza@protonmail.com>
 *
 * Distributed under terms of GPL license
 */

lazy val root = (project in file("."))
  .settings (
    name         := "Advent of Code 2021",
    scalaVersion := "3.1.0",
    organization := "com.github.marcosro.aoc21",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest-funsuite" % "3.2.10" % "test"
    )
  )
