package com.practice.learning.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  //Class parameters of case class are fields.
  val jim = new Person("Jim", 21)
  println(jim.name)
  // Println jim returns class toString
  println(jim)
  //Equals and hashcode
  val jim2 = new Person("Jim", 21)
  println(jim == jim2)
  //Copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)
  //Companion objects (we dont need new word)
  val mary = Person("Mary", 25)
  println(mary)

  //Also we can do cas objects
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  val uk = UnitedKingdom
  println(uk.name)


}
