package com.practice.learning.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = { //The value we pass here remains the same while method is running.
    println("byValue: " + x)
    println("byValue: " + x)
  }

  def calledByName(x: => Long): Unit = { //The value changes (=>) even if the method is running.
    println("byName: " + x)
    println("byName: " + x)
  }

  println(calledByValue(System.nanoTime())) //Same print
  println(calledByName(System.nanoTime())) //Different print

}
