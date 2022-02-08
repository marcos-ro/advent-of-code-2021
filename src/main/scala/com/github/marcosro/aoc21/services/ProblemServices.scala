package com.github.marcosro.aoc21.services

import scala.io.AnsiColor
import com.github.marcosro.aoc21.models.Problem
import com.github.marcosro.aoc21.models.cli.CLI
import com.github.marcosro.aoc21.models.cli.commands.Command
import com.github.marcosro.aoc21.models.cli.programs.Program
import com.github.marcosro.aoc21.models.cli.jdk.CLIJDK

object ProblemServices:
  import Command._
  import Program._

  def interpreter: CLI =
    new CLIJDK

  def fromFile[A](path: String)(processing: String => A): Program[List[A]] =
    Execute(FromFile(path, processing))  

  def resolver[A, B](problem: Problem[A], processing: A => B): Program[Unit] =
    Execute(Resolver(problem, processing)).flatMap { result =>
      val part = problem.part  
      Execute(Println(f"${AnsiColor.BOLD}resolve${AnsiColor.RESET}(${AnsiColor.BOLD}${AnsiColor.CYAN}$part${AnsiColor.RESET}): ${AnsiColor.BOLD}$result${AnsiColor.YELLOW}"))
    }

  def error(text: String): Program[Unit] =
    Execute(Println(f"${AnsiColor.BOLD}error${AnsiColor.RESET}(${AnsiColor.BOLD}${AnsiColor.RED}$text${AnsiColor.RESET})"))

  def pass: Program[Unit] =
    error("Not implemented yet")
