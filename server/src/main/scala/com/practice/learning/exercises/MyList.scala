package com.practice.learning.exercises

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](n: B): MyList[B]

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](n: B): MyList[B] = new Cons(n, this)

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transformElement(h), t.map(transformer))

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transformElement(h) ++ t.flatMap(transformer)

  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transformElement(element: A): B
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = Cons("Hi", new Cons("Hello", new Cons("Bye", Empty)))

  println(listOfIntegers.head)
  println(listOfStrings.head)
}
