package com.github.marcosro.aoc21.lib

def measurementIncreases(measurements: List[Int], knowMeasurements: List[Int] = List(), increases: Int = 0): Int =
  measurements match
    case Nil => increases
    case x :: xs =>
      val processing = measurementIncreases(xs, _ : List[Int], _ : Int)
      if knowMeasurements.isEmpty then
        processing(knowMeasurements.appended(x), increases)
      else
        val oldX = knowMeasurements.last
        if x > oldX then
          processing(knowMeasurements.appended(x), increases+1)
        else
          processing(knowMeasurements.appended(x), increases)

def measurementIncreasesWithWindows(measurements: List[Int], windows: List[Int] = List(), increases: Int = 0): Int =
  measurements match
    case Nil => increases
    case x :: xs =>
      val sum = xs.take(2).sum + x
      val processing = measurementIncreasesWithWindows(xs, _: List[Int], _: Int)
      if windows.isEmpty then
        processing(windows.appended(sum), increases) 
      else
        val oldSum = windows.last
        if sum > oldSum then
          processing(windows.appended(sum), increases+1)
        else
          processing(windows.appended(sum), increases) 

def processing(commands: List[(String, Int)], position: (Int, Int) = (0, 0)): Int =
  val (horizontal, depth) = position
  commands match
    case Nil => horizontal * depth
    case x :: xs =>
      val partialProcessing = processing(xs, _: (Int, Int))
      x match
        case ("forward", units: Int)  =>
          val updatedPosition = (horizontal+units, depth)
          partialProcessing(updatedPosition)
        case ("up", units: Int) =>
          val updatedPosition = (horizontal, Math.abs(depth-units))
          partialProcessing(updatedPosition)
        case ("down", units: Int) =>
          val updatedPosition = (horizontal, depth+units)
          partialProcessing(updatedPosition)

def processingWithAIM(commands: List[(String, Int)], position: (Int, Int, Int) = (0, 0, 0)): Int =
  val (horizontal, depth, aim) = position
  commands match
    case Nil => horizontal * depth
    case command::_commands =>
      val partialProcessing = processingWithAIM(_commands, _: (Int, Int, Int))
      command match
        case ("forward", units: Int) =>
          val updatedPosition =
            if aim == 0 then
              (horizontal+units, depth, aim)
            else
              (horizontal+units, depth+units*aim, aim) 
          partialProcessing(updatedPosition)
        case ("up", units: Int) =>
         val updatedPosition = (horizontal, depth, Math.abs(aim-units)) 
          partialProcessing(updatedPosition)
        case ("down", units: Int) =>
          val updatedPosition = (horizontal, depth, aim+units)
          partialProcessing(updatedPosition)
