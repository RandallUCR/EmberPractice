package com.practice.learning.part2oop

object MethodNotations extends App {
  class Person (val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = this.favoriteMovie == movie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def apply(): String = s"Hi ${this.name}"
  }

  val mary = new Person("Mary", "Fast And Furious")
  println(mary.likes("Fast And Furious"))
  println(mary likes "Fast And Furious") //Equivalent to above one only works with one parameter
  val tom = new Person("Tom", "Purge")
  println(mary hangOutWith tom)
  println(mary()) //If the method is named apply() we can call it without name
}
