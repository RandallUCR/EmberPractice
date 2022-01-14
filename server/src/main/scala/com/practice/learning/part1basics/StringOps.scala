package com.practice.learning.part1basics

object StringOps extends App {

  val str = "Hello, im learning scala"

  println(str.charAt(4))
  println(str.substring(7, 9))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toUpperCase() + " --- " + str.toLowerCase())
  println(str.reverse)
  println(str.take(5))

  val number = "43"
  println(number.toInt + 5) //Parse to int

  //S Interpolator
  val name = "Randall"
  val age = 22
  val greeting = s"Hello, my name is $name and I am ${age + 1} years old"
  println(greeting)

  //F Interpolator
  val speed = 300.1f
  val car = "Ferrari"
  println(f"The $car can run $speed%3.3f km/h")

  //Raw Interpolator
  println("This is a \n new line") //Normal
  println(raw"This is a \n new line") //Raw

}
