package com.github.marcosro.aoc21.models.cli.jdk

import com.github.marcosro.aoc21.models.cli.CLI
import com.github.marcosro.aoc21.models.cli.commands.Command
import com.github.marcosro.aoc21.models.cli.programs.Program

class CLIJDK extends CLI:
  import Command._
  import Program._

  override def run[A](program: Program[A]): A =
    program match
      case RunAndThen(program, processing) =>
        val value = run(program)
        run(processing(value))
      case Execute(Resolver(problem, processing)) =>
        processing(problem.input)
      case Execute(Banner()) =>
        UtilitiesJDK.banner
      case Execute(Prompt(text)) =>
        ConsoleJDK.readLn(text)
      case Execute(Println(text)) =>
        ConsoleJDK.printLn(text)
      case Execute(Command.NewLine()) =>
        ConsoleJDK.newLine
      case Execute(Command.FromFile(path, processing)) =>
        FromFileJDK.fromFile(path, processing)
      case Return(value) =>
        value
