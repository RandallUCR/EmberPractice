package com.practice.learning.part2oop

object Inheritance extends App {

  //Inheritance Animal example
  class Animal {
    val creatureType = "domestic" //Add final at the begin to make this val no overridable
    def eat: Unit = println("nom-nom")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunch-crunch")
    }
  }

  val cat = new Cat
  cat.eat
  cat.crunch

  class Dog (override val creatureType: String) extends Animal { //Overriding Animal (parent) val
    override def eat: Unit = println("override method") //Overriding Animal (parent) class function
  }

  val dog = new Dog ("K9")
  dog.eat
  println(dog.creatureType)

  //Inheritance Person example
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 18)
  }

  class Adult(name: String, age: Int, idCart: String) extends Person(name) //We can use this instance because Person has an extra constructor

}
