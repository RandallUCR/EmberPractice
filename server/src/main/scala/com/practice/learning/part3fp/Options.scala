package com.practice.learning.part3fp

import scala.util.Random

object Options extends App {
//Options is for functions that may return null
  val myFirstOption: Option [Int] = Some(4)
  val noOption: Option [Int] = None

  println(myFirstOption)

  def unsafeMethod(): String = null
  val result = Option(unsafeMethod)
  println(result)

  //chained method
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  //Unsafe API
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A Valid Result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod
  println(betterChainedResult)

  //functions and options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //This is unsafe

  //map, flatmap, filter
  println(myFirstOption.map(_ *2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  //Exercise
  val config: Map[String, String] = Map(
    "host" -> "192.168.0.1",
    "port" -> "3030"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None

  }

  //try to establish a connection
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)




}
