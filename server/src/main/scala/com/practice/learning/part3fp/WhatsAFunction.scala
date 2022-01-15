package com.practice.learning.part3fp

object WhatsAFunction extends App {

 /* val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))*/
//Functional programming
  val stringToInt = new Function1 [String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToInt("3")+3)

  def concatStrings: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatStrings("Hello", "World"))

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int,Int]] {
    override def apply(x: Int): Int => Int = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))

  println(superAdder(3)(4)) //curried function

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
