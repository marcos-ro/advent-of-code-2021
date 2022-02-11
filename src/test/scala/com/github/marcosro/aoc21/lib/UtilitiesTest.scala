package com.github.marcosro.aoc21.lib

import org.scalatest.funsuite.AnyFunSuite

class UtilitiesTest extends AnyFunSuite:
  test("Testing a support function to resolve day 01") {
    val fakeInput = List(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
    assert(measurementIncreases(fakeInput) == 7)
    assert(measurementIncreasesWithWindows(fakeInput) == 5)
  }

  test("Testing a support function to resolve day 02") {
    val fakeInput = List(("forward", 5), ("down", 5), ("forward", 8), ("up", 3), ("down", 8), ("forward", 2))
    assert(processing(fakeInput) == 150)
    assert(processingWithAIM(fakeInput) == 900)
  }
