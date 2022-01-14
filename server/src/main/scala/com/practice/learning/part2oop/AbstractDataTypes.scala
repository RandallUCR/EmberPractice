package com.practice.learning.part2oop

object AbstractDataTypes extends App {
//Abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal { //Is needed to override functions from the parent (abstract class)
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch-crunch")
  }
//Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Carnivore {
    override def eat(animal: Animal): Unit = println("ror-ror")
  }

  /* Abstract vs Traits
  * 1- Traits cannot have constructor params until scala 3
  * 2- Multiple traits can be inherited by the same class
  * 3- Abstract is a thing, traits is what that thing do*/


}
