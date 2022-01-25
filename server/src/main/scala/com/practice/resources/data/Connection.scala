package com.practice.resources.data
import java.sql.{Connection, DriverManager, ResultSet}


object Connection {

  val url = "jdbc:mysql://127.0.0.1:3306/practice"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = ""


  def execute(query: String): ResultSet = {
    var output: ResultSet = null
    try {
      Class.forName(driver)
      val connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement
      val rs = statement.executeQuery(query)
      output = rs
      println("Success")
    } catch {
      case e: Exception => println(e.getMessage)
    }
    output
  }

}
