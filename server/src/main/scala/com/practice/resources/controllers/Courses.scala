package com.practice.resources.controllers

import cats.effect.IO
import com.practice.resources.Main.{delete, get, jsonBody, patch, path, post}
import io.circe.Json
import io.circe.syntax.EncoderOps
import io.finch.{Endpoint, Ok, NoContent}
import io.finch.circe._
import io.circe.generic.auto._

object Courses {

  case class CourseAttrs(room: Int, name: String)

  case class Course(`type`: String = "courses", id: Int, attributes: CourseAttrs)

  case class NewCourse(`type`: String = "courses", attributes: CourseAttrs)

  case class NormalizedResponse(data: Course)

  case class NewNormalizedResponse(data: NewCourse)

  case class NormalizedArrayResponse(data: Array[Course])

  var courses = Array(Course(id = 0, attributes = CourseAttrs(35, "Maths")),
    Course(id = 1, attributes = CourseAttrs(30, "Calc")), Course(id = 2, attributes = CourseAttrs(40, "Spanish")))

  val getCourses: Endpoint[IO, Json] = get("courses") {
    Ok(NormalizedArrayResponse(courses).asJson)
  }

  val getCourse: Endpoint[IO, Json] = get("courses" :: path[Int]) { id: Int =>
    Ok(NormalizedResponse(courses(id)).asJson)
  }

  val addCourse: Endpoint[IO, Json] = post("courses" :: jsonBody[NewNormalizedResponse]) { resp: NewNormalizedResponse =>
      val auxId = courses.last.id + 1
      courses = courses :+ Course(id = auxId, attributes = CourseAttrs(resp.data.attributes.room, resp.data.attributes.name))
      Ok(NormalizedResponse(courses.last).asJson)
  }

  val editCourse: Endpoint[IO, Json] = patch("courses" :: path[Int] :: jsonBody[NormalizedResponse]) { (id: Int, resp: NormalizedResponse) =>
    courses(id) = resp.data
    Ok(NormalizedResponse(courses(id)).asJson)
  }

  val delCourse: Endpoint[IO, Unit] = delete("courses" :: path[Int]) { id: Int =>
    courses(id) = Course(id = -1, attributes = CourseAttrs(-1, " "))
    NoContent[Unit]
  }

}
