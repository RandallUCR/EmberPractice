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

  val api: Service[Request, Response] =
    Bootstrap.configure(includeDateHeader = true, includeServerHeader = true)
      .serve[Text.Plain](sayHi)
      .serve[Application.Json](jsonList)
      .serve[Application.Json](classList)
      .toService

  Await.ready(Http.server.serve(":8080", api))

}
