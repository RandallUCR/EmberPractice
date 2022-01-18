package com.practice.learning.part4pm

import com.practice.learning.exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

  //constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The truth"
    case AllThePatterns => "A single object"
  }

  //match anything
  val matchAnything = x match {
    case _ =>
  }

  //variable
  val matchVariable = x match {
    case something => s"Ive found $something"
  }

  //tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"Ive found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  //PM can be nested.

  //case classes construction pattern
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subHead, subTail)) =>
  }

  //list patterns
  val aStandardList = List(1, 2, 3, 4, 5)
  val aStandarListMatch = aStandardList match {
    case List(1, _, _, _, _) =>
    case List(1, _*) => //List of arbitrary length
    case 1 :: List(_) => //infix pattern
    case List(1, 2, 3) :+ 42 => //infix pattern
  }

  //type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => //explicit type specifier
    case _ =>
  }

  //name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => //name binding => use names later
    case Cons(1, rest @ Cons(2, _)) => //name binding inside nested patterns
  }

  //multi patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => //compound pattern
  }

  //if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 ==0 =>
  }
}
