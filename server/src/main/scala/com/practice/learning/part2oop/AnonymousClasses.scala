package com.practice.learning.part2oop

object AnonymousClasses extends  App{
//Example 1
  abstract  class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal { //An instance of an abstract class?
    override def eat: Unit = println("hahahahaha")
  }

  funnyAnimal.eat
  println(funnyAnimal.getClass) //Actually internally is an anonymous class created when we do this.
//Example 2
  class Person(name: String){
    def sayHi: Unit = println(s"Hi ${this.name}")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi my name is Jim")
  }

  jim.sayHi

}
