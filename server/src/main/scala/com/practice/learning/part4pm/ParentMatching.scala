package com.practice.learning.part4pm

import scala.util.Random

object ParentMatching extends App {

  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The ONE"
    case 2 => "Double or nothing"
    case 3 => "Third is the time"
    case _ => "Something else"
  }

  println(x)
  println(description)

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and i cant drink in USA"
    case Person(n, a) => s"Hi my name is $n and im $a years old"
    case _ => "I dont know who i am"
  }

  println(greeting)

  class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses (exp: Expr) = exp match {
        case Prod(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }

  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
}
