package com.practice.resources

import io.finch._
import cats.effect.IO
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, Service}
import com.twitter.util.Await
import io.circe.Json
import io.circe.syntax.EncoderOps
import io.finch.circe._, io.circe.generic.auto._

object Main extends App with Endpoint.Module[IO] {

  val sayHi: Endpoint[IO, String] = get("sayHi") {
    Ok("Hello World")
  }

  val jsonList: Endpoint[IO, Json] = get("jsonList") {
    Ok(List(1, 2, 3).asJson)
  }

  case class Class(size: Int, name: String)

  val classList: Endpoint[IO, Json] = get("classList") {
    Ok(List(Class(3, "Math"), Class(7, "Calc"), Class(1, "Spanish")).asJson)
  }

  //Courses example

  case class Course(id: Int, room: Int, name: String)

  var courses = Array(Course(0, 35, "Maths"), Course(1, 30, "Calc"), Course(2, 40, "Spanish"))

  val getCourses: Endpoint[IO, Json] = get("courses") {
    Ok(courses.asJson)
  }

  val getCourse: Endpoint[IO, Json] = get("course" :: path[Int]) { id: Int =>
    Ok(courses(id).asJson)
  }

  val addCourse: Endpoint[IO, Json] = post("course" :: jsonBody[Course]) { course: Course =>
    courses = courses :+ course
    Ok(courses.asJson)
  }

  val editCourse: Endpoint[IO, Json] = patch("course" :: jsonBody[Course]) { course: Course =>
    courses(course.id) = course
    Ok(courses.asJson)
  }

  val delCourse: Endpoint[IO, Json] = delete("course" :: path[Int]) { id: Int =>
    courses(id) = Course(-1, -1, " ")
    Ok(courses.asJson)
  }

  val api: Service[Request, Response] =
    Bootstrap.configure(includeDateHeader = true, includeServerHeader = true)
      .serve[Text.Plain](sayHi)
      .serve[Application.Json](jsonList)
      .serve[Application.Json](classList)
      .serve[Application.Json](getCourses)
      .serve[Application.Json](getCourse)
      .serve[Application.Json](addCourse)
      .serve[Application.Json](editCourse)
      .serve[Application.Json](delCourse)
      .toService

  Await.ready(Http.server.serve(":8080", api))

}
