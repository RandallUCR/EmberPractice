package com.practice.learning.part3fp

import scala.util.Random

object Sequences extends App {
  //Seq
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(9, 5, 6))
  println(aSequence.sorted)
  //Range
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  (20 to 30).foreach(x => println("Hello " + x))

  //lists
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 85
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  //arrays (can be mutated)
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)
  numbers(2) = 0
  println(numbers.mkString(" "))

  //array and seq
  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq)

  //vector
  val vector: Vector[Int] = Vector(1,2,3,4)
  println(vector)

  val maxRuns = 1000
  val maxCapacity = 100000

  def getWriteTime (collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numberList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector

  println(getWriteTime(numberList))
  println(getWriteTime(numberVector))

}
