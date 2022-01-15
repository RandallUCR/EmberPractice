package com.practice.learning.part3fp

object HOFsCurries extends App {

  //High order function HOF = function that takes functions as parameters and returns functions
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  val niceAdder: (Int, Int) => Int = _ + _

  //This functions params are =  func, Int, Int and returns an Int, that is the function received as parameter
  def hof(f: (Int, Int) => Int, x: Int, y: Int): Int = f(x, y)
  println(hof(niceAdder, 3, 4))

  //Curried function
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(10))

  //Curried with multiple parameters list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val format: (Double => String) = curriedFormatter("%3.3f")

  println(format(2.123451))

}
