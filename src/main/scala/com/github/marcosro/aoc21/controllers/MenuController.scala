package com.github.marcosro.aoc21.controllers

import com.github.marcosro.aoc21.models.cli.programs.Program
import com.github.marcosro.aoc21.services.MenuServices

class MenuController(problemController: ProblemController):
  def loop: Unit =
    while(processing) {}

  private def processing: Boolean =
    val program = prompt("menu").replaceAll("0", "") match
      case "1" => resolve("1")
      case "2" => resolve("2")
      case otherwise => default(otherwise)

    MenuServices.interpreter.run(program)

  private def prompt(option: String): String =
    val program = option match
      case "menu" => MenuServices.main
      case "day_submenu" => MenuServices.resolve

    MenuServices.interpreter.run(program)

  private def resolve(day: String): Program[Boolean] =
    problemController.resolve(day, prompt("day_submenu"))
    MenuServices.continue

  private def default(value: String): Program[Boolean] =
    if value == "" then
        MenuServices.exit
    else
        MenuServices.error("Is not valid value").flatMap { unit =>
          MenuServices.continue
        }
