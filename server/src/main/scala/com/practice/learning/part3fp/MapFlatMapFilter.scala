package com.practice.learning.part3fp

object MapFlatMapFilter extends App {

  val list = List(1, 2, 3, 4)
  println(list.head)
  println(list.tail)
  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))
  //filter
  println(list.filter(_ % 2 == 0))
  //flatMap
  val toPair = (x: Int) => List(x, (x + 1))
  println(list.flatMap(toPair))

  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val combinations = list.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  list.foreach(println)

  //for-comprehensions
  val forCombinations = for { //in this way we can do the same than flatMap for val combinations
    n <- list
    c <- chars
    colors <- colors
  } yield "" + c + n + "-" + colors
  println(forCombinations)

  val forCombinations2 = for {
    n <- list if n % 2 == 0
    c <- chars
    colors <- colors
  } yield "" + c + n + "-" + colors
  println(forCombinations2)

  //syntax overload
  val mapped = list.map { x =>
    x * 2
  }
  println(mapped)

}
