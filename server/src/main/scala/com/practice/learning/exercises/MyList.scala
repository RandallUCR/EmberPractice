package com.practice.learning.exercises

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](n: B): MyList[B]
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)
}

class Cons [+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](n: B): MyList[B] = new Cons(n, this)
}

object ListTest extends App {
  val listOfIntegers: MyList [Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList [String] = new Cons("Hi", new Cons("Hello", new Cons("Bye", Empty)))

  println(listOfIntegers.head)
  println(listOfStrings.head)
}
