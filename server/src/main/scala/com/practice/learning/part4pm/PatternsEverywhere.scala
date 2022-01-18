package com.practice.learning.part4pm

object PatternsEverywhere extends App {
  try {
    //code
  } catch { // Catches are Matches
    case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "Null Pointer"
    case _ => "Something else"
  }

  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield println(10 * x)

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  }yield println(first * second)

  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)

  val head :: tail = list
  println(head)
  println(tail)

  val mappedList = list.map{
    case v if v % 2 == 0 => v + " is even"
    case 1 => "The one"
    case _ => "Something else"
  }

  println(mappedList)
}
