package com.github.marcosro.aoc21.models.cli:
  import com.github.marcosro.aoc21.models.cli.programs.Program

  trait CLI:
    def run[A](program: Program[A]): A

  package commands:
    import com.github.marcosro.aoc21.models.Problem
    enum Command[A]:
      case Resolver[A, B](fun: A => B, problem: Problem[A]) extends Command[B]
      case Prompt[A](text: String) extends Command[String]
      case NewLine() extends Command[Unit]
      case Banner() extends Command[Unit]


  package programs:
    import com.github.marcosro.aoc21.models.cli.commands.Command

    enum Program[A]:
      case Execute[A](command: Command[A]) extends Program[A]
      case Return[A](value: A) extends Program[A]
      case RunAndThen[A, B](program: Program[A], next: A => B) extends Program[B]

      def andThen[B](fun: A => B): Program[B] =
        RunAndThen(this, fun)
