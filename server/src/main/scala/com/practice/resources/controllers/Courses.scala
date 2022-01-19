package com.practice.resources.controllers

import cats.effect.IO
import com.practice.resources.Main.{delete, get, jsonBody, patch, path, post}
import io.circe.Json
import io.circe.syntax.EncoderOps
import io.finch.{Endpoint, Ok}
import io.finch.circe._, io.circe.generic.auto._

object Courses {

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

}
