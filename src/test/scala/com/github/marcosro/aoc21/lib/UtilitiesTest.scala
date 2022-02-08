package com.github.marcosro.aoc21.lib

import org.scalatest.funsuite.AnyFunSuite

class UtilitiesTest extends AnyFunSuite:
  test("Testing a support function to resolve day 01") {
    val fakeInput = List(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
    assert(measurementIncreases(fakeInput) == 7)
    assert(measurementIncreasesByWindows(fakeInput) == 5)
  }
