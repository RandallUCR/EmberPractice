package com.practice.learning.part2oop

object Exceptions extends App {

  val x: String = null
  try {
    println(x.length)
  } catch {
    case e: NullPointerException => println("Not an string, Error: " + e.getMessage)
  } finally {
    println("Finally")
  }

  //Creating my own exception
  class MathCalculationException extends RuntimeException("Division by zero")

  object Calculator {
    def div(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  val div = Calculator
  println(div.div(4, 0))

}
