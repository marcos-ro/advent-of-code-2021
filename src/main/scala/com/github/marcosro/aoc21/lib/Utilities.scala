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

def measurementIncreasesByWindows(measurements: List[Int], windows: List[Int] = List(), increases: Int = 0): Int =
  measurements match
    case Nil => increases
    case x :: xs =>
      val sum = xs.take(2).sum + x
      val processing = measurementIncreasesByWindows(xs, _: List[Int], _: Int)
      if windows.isEmpty then
        processing(windows.appended(sum), increases) 
      else
        val oldSum = windows.last
        if sum > oldSum then
          processing(windows.appended(sum), increases+1)
        else
          processing(windows.appended(sum), increases) 
