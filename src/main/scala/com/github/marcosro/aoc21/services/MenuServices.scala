package com.github.marcosro.aoc21.services

import scala.io.AnsiColor
import com.github.marcosro.aoc21.models.cli.CLI
import com.github.marcosro.aoc21.models.cli.commands.Command
import com.github.marcosro.aoc21.models.cli.programs.Program
import com.github.marcosro.aoc21.models.cli.jdk.CLIJDK

object MenuServices:
  import Command._
  import Program._

  def interpreter: CLI =
    new CLIJDK

  def main: Program[String] =
    Execute(Banner()).flatMap { unit =>
      Execute(Prompt(f"Typing a day to resolve[${AnsiColor.BOLD}${AnsiColor.CYAN}01-25${AnsiColor.RESET}]: "))
    }

  def resolve: Program[String] =
    Execute(NewLine()).flatMap { unit =>
      Execute(Prompt(f"Typing a part to resolve[${AnsiColor.BOLD}${AnsiColor.CYAN}01-02${AnsiColor.RESET}]: "))
    }

  def continue: Program[Boolean] =
    Return(true)

  def exit: Program[Boolean] =
    Return(false)

  def error(text: String): Program[Unit] =
    Execute(Println(f"${AnsiColor.BOLD}error${AnsiColor.RESET}(${AnsiColor.BOLD}${AnsiColor.RED}$text${AnsiColor.RESET})"))
