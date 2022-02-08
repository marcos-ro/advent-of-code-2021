package com.github.marcosro.aoc21.models.cli:
  import com.github.marcosro.aoc21.models.cli.programs.Program

  trait CLI:
    def run[A](program: Program[A]): A

  package commands:
    import com.github.marcosro.aoc21.models.Problem
    enum Command[A]:
      case Resolver[A, B](problem: Problem[A], processing: A => B) extends Command[B]
      case FromFile[A](path: String, processing: String => A) extends Command[List[A]]
      case Prompt[A](text: String) extends Command[String]
      case Println(text: String) extends Command[Unit]
      case NewLine() extends Command[Unit]
      case Banner() extends Command[Unit]


  package programs:
    import com.github.marcosro.aoc21.models.cli.commands.Command

    enum Program[A]:
      case Execute[A](command: Command[A]) extends Program[A]
      case Return[A](value: A) extends Program[A]
      case RunAndThen[A, B](program: Program[A], processing: A => Program[B]) extends Program[B]

      def map[B](processing: A => B): Program[B] =
        RunAndThen(this, value => Return(processing(value)))

      def flatMap[B](processing: A => Program[B]): Program[B] =
        RunAndThen(this, processing)
