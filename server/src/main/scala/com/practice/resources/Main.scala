package com.practice.resources

import io.finch._
import cats.effect.IO
import com.practice.resources.controllers.Courses
import com.twitter.finagle.http.filter.Cors
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, Service}
import com.twitter.util.Await
import io.circe.Json
import io.circe.syntax.EncoderOps
import io.finch.circe._
import io.circe.generic.auto._

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

  val courses = Courses

  val api: Service[Request, Response] = {
    Bootstrap.configure(includeDateHeader = true, includeServerHeader = true)
      .serve[Text.Plain](sayHi)
      .serve[Application.Json](jsonList)
      .serve[Application.Json](classList)
      .serve[Application.Json](courses.getCourses)
      .serve[Application.Json](courses.getCourse)
      .serve[Application.Json](courses.addCourse)
      .serve[Application.Json](courses.editCourse)
      .serve[Application.Json](courses.delCourse)
      .toService
  }

  val policy: Cors.Policy = Cors.Policy(
    allowsOrigin = _ => Some("*"),
    allowsMethods = _ => Some(Seq("GET", "POST", "PATCH", "DELETE")),
    allowsHeaders = _ => Some(Seq("Accept", "Content-type"))
  )

  val corsService: Service[Request, Response] = new Cors.HttpFilter(policy).andThen(api)

  Await.ready(Http.server.serve(":8080", corsService))

}
