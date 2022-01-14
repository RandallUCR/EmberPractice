package com.practice.learning.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + "-" + b
  }

  println(aFunction("hello", 3))

  def noParams(): Int = 45

  println(noParams) //Can be called with not parentheses

  def recursiveFunc(a: String, b: Int): String = { //Instead of loops is better to use recursive functionqs
    if (b == 1) a + "!"
    else a + "-" + recursiveFunc(a, b - 1)
  }

  println(recursiveFunc("randall", 4))

  def voidFunc(a: String): Unit = a //This should not print nothing

  println(voidFunc("hi"))

  def bigFunction(n: Int): Int = {
    def smallFunction(a: Int, b: Int): Int = a + b

    5 + smallFunction(n, n - 1)
  }

  println(bigFunction(3))


}
