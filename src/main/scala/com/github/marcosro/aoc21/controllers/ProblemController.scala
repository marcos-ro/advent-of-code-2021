package com.github.marcosro.aoc21.controllers

import com.github.marcosro.aoc21.models.Problem
import com.github.marcosro.aoc21.models.cli.programs.Program
import com.github.marcosro.aoc21.services.ProblemServices
import com.github.marcosro.aoc21.lib._

class ProblemController():
  def resolve(day: String, part: String): Unit =
    val program = day.replaceAll("0", "") match
      case "1" => day01(part)
      case "2" => day02(part)
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
          ProblemServices.resolver(problem, (input: List[Int]) => measurementIncreasesWithWindows(input))
        case otherwise => ProblemServices.error(f"The part $part, not exists")
    }

  private def day02(part: String): Program[Unit] =
    val program = ProblemServices.fromFile("input/day_02.txt") { line =>
      val items = line.split(" ")
      (items(0), items(1).toInt)
    }

    program.flatMap { input =>
      part.replaceAll("0", "") match
        case "1" =>
          val problem = Problem(1, input)
          ProblemServices.resolver(problem, (input: List[(String, Int)]) => processing(input))
        case "2" =>
          val problem = Problem(2, input)
          ProblemServices.resolver(problem, (input: List[(String, Int)]) => processingWithAIM(input))
        case otherwise => ProblemServices.error(f"The part $part, not exists")
    }
