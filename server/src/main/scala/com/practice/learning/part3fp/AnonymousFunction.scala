package com.practice.learning.part3fp

object AnonymousFunction extends App {

  //Anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2
  println(doubler(4))

  //multiple params in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  println(adder(2, 4))

  //no params
  val justDoSomething: () => Int = () => 3
  println(justDoSomething())

  //curly braces
  val stringToInt = { (str: String) =>
    str.toInt
  }
  println(stringToInt("4") + 1)

  //More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  println(niceIncrementer(5))

  val niceAdder: (Int, Int) => Int = _ + _
  println(niceAdder(7, 3))

  //Same as WhatsAFunction superAdder but sugar
  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(6)(5))


}
