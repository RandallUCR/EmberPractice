package com.practice.learning.part2oop

object Objects extends App {

  //Scala object = Singleton instance
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(parent: Person, mother: Person): String = s"Father: ${parent.name} , Mother: ${mother.name}"
  }

  println(Person.N_EYES)
  println(Person.canFly)

  var mary = Person
  var john = Person
  println(mary == john) //This is true because mary and john are equals to a singleton

  class Person(val name: String)

  var mary2 = new Person("Mary")
  var john2 = new Person("John")
  println(mary2 == john2) //This is false because classes works with instances

  val bobbie = Person(john2, mary2)
  println(bobbie)
}
