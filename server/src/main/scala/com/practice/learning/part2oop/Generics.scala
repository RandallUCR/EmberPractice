package com.practice.learning.part2oop

object Generics extends App {

  class Animal
  class Cat extends  Animal
  class Dog extends Animal

  class InvariantList[A]//Invariants needs to be the same element Animal = Animal
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  class CovariantList[+A]//Co-variants works like inheritance Animal = Cat
  val covariantAnimalList: CovariantList[Animal] = new CovariantList[Cat]
  //We cannot like add(new Dog) because we are polluting the list of cats,
  // so in this cases we need to add a super type [B >: A], check MyList in exercises, this will convert a list of Cats in a list of Animals.
  //This issue is known as variance problem

  class ContravariantList[-A]//Contra-variants works opposite like inheritance Cat = Animal
  val contravariantAnimalList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Bounded[A <: Animal] (animal: A)//Only will accept subtypes of Animal
  val bounded = new Bounded(new Dog)


}
