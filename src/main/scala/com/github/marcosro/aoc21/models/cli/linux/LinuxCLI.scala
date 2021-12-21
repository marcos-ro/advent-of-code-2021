package com.github.marcosro.aoc21.models.cli.linux

import com.github.marcosro.aoc21.models.cli.CLI
import com.github.marcosro.aoc21.models.cli.commands.Command
import com.github.marcosro.aoc21.models.cli.programs.Program

class LinuxCLI extends CLI:
  override def run[A](program: Program[A]): A =
    program match
      case Program.RunAndThen(program, next) =>
        val result = run(program)
        next(result)
      case Program.Execute(Command.Resolver(fun, problem)) =>
        fun(problem.input)
      case Program.Execute(Command.Banner()) =>
        BannerLinux.show
      case Program.Execute(Command.Prompt(text)) =>
        PromptLinux.readLn(text)
      case Program.Execute(Command.NewLine()) =>
        PromptLinux.newLine
      case Program.Return(value) =>
        value
