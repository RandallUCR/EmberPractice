package com.practice.learning.part3fp

object TuplesAndMaps extends App {

  val aTuples = (2, "hello, scala")

  println(aTuples._1)
  println(aTuples.copy(_2 = "goodbye Java"))
  println(aTuples.swap)

  //Maps - key -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map("Jim" -> 555, "Daniel" -> 666).withDefaultValue(-1)
  println(phoneBook)

  //map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Mary"))

  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap)
  println(phoneBook.mapValues(number => number * 10).toMap)
  println(phoneBook.mapValues(number => "aaa" + number).toMap)

  //Conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}
