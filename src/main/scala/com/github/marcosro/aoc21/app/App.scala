package com.github.marcosro.aoc21.app

import com.github.marcosro.aoc21.controllers.{MenuController, ProblemController}

@main
def main: Unit =
  val controller = new MenuController(new ProblemController())
  controller.loop
