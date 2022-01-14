package com.practice.learning.part2oop

object OOBasics extends App {

  val person = new Person("Randall", 23)
  println(person.age)
  println(person.x)
  person.greet("Lucia")
  person.greet()

  val person2 = new Person(name = "Maria")
  println(person2.name)
  println(person2.age)

  val author = new Writer("Randall", "Centeno", 1998)
  val novel = new Novel("Unica mirando al mar", 2022, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val impostorAuthor = new Writer("Randall", "Centeno", 1998)
  println(novel.isWrittenBy(impostorAuthor))

  val counter = new Counter //The init amount is defined in class constructor
  counter.inc.print
  counter.inc.inc.inc(6).dec.dec(5).print
}

//class Person (name: String, age: Int) //Class parameters are NOT fields.
class Person(val name: String, val age: Int) { //We need to set them as var or val to use them as fields
  val x = 2
  println(1 + 4)

  //class method
  def greet(name: String): Unit = println(s"${this.name} says hello to $name")

  //overloading
  def greet(): Unit = println(s"Hello ${this.name}")

  //multiple constructors
  def this(name: String) = this(name, 0) //We need to set default variables for extra constructors
}

// Practice Writer - Novel
class Writer(firstName: String, surName: String, val year: Int) {
  def fullName(): String = firstName + " " + surName
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge: Int = this.year - this.author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

// Practice Counter //Immutability - If we want to change some class value, is better to create a new instance with the values changed
class Counter(val count: Int = 0) {
  def inc: Counter = {
    println("Incrementing...")
    new Counter(this.count + 1)
  }

  def dec: Counter = {
    println("Decrementing...")
    new Counter(this.count - 1)
  }

  def inc(n: Int): Counter = {
    println("Incrementing...")
    new Counter(this.count + n)
  }

  def dec(n: Int): Counter = {
    println("Decrementing...")
    new Counter(this.count - n)
  }

  def print: Unit = println("The countis: " + this.count)
}
