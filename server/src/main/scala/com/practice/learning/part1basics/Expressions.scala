package com.practice.learning.part1basics

object Expressions extends App {
  var x = 1 + 2 * 3
  println(x)

  println(x == 1)
  println(!(x == 1))

  var y = 3
  y += 2
  println(y)

  var condition = false
  var conditioned = if (condition) 5 else 6
  println(conditioned)

  var codeBlock = {
    val one = 12
    val two = 15
    if (one == 12) "hello" else "bye"
  }

  println(codeBlock)

  var index = 0
  while (index < 3) {
    println("Index: " + index)
    index += 1
  }


}
