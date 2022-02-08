package com.github.marcosro.aoc21.controllers

import com.github.marcosro.aoc21.models.Problem
import com.github.marcosro.aoc21.models.cli.programs.Program
import com.github.marcosro.aoc21.services.ProblemServices
import com.github.marcosro.aoc21.lib._

class ProblemController():
  def resolve(day: String, part: String): Unit =
    val program = day.replaceAll("0", "") match
      case "1" => day01(part)
      case otherwise => ProblemServices.error("Not valid day")

    ProblemServices.interpreter.run(program)

  private def day01(part: String): Program[Unit] =
    val program = ProblemServices.fromFile("input/day_01.txt") { line =>
      line.toInt
    }

    program.flatMap { input =>
      part.replaceAll("0", "") match 
        case "1" =>
          val problem = Problem(1, input)
          ProblemServices.resolver(problem, (input: List[Int]) => measurementIncreases(input))
        case "2" =>
          val problem = Problem(2, input)
          ProblemServices.resolver(problem, (input: List[Int]) => measurementIncreasesByWindows(input))
        case otherwise => ProblemServices.error(f"The part $part, not exists")
    }
