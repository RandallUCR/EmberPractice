package com.practice.resources.controllers

import cats.effect.IO
import com.practice.resources.Main.{delete, get, jsonBody, patch, path, post}
import com.practice.resources.data.Connection.execute
import io.circe.Json
import io.circe.syntax.EncoderOps
import io.finch.{Endpoint, NoContent, Ok}
import io.finch.circe._
import io.circe.generic.auto._

object Courses{

  case class CourseAttrs(room: Int, name: String)

  case class Course(`type`: String = "courses", id: Int, attributes: CourseAttrs)

  case class NewCourse(`type`: String = "courses", attributes: CourseAttrs)

  case class NormalizedResponse(data: Course)

  case class NewNormalizedResponse(data: NewCourse)

  case class NormalizedArrayResponse(data: Array[Course])

  var courses = Array(Course(id = 0, attributes = CourseAttrs(35, "Maths")),
    Course(id = 1, attributes = CourseAttrs(30, "Calc")), Course(id = 2, attributes = CourseAttrs(40, "Spanish")))

  val getCourses: Endpoint[IO, Json] = get("courses") {
    var list = Array[Course]()
    val rs = execute("CALL get_courses;")
    while(rs.next()){
        val c = Course(
          id = rs.getInt("id"),
          attributes = CourseAttrs (
            rs.getInt("room"),
            rs.getString("name")
          )
        )
      list = list :+ c
    }
    Ok(NormalizedArrayResponse(list).asJson)
  }

  val getCourse: Endpoint[IO, Json] = get("courses" :: path[Int]) { id: Int =>
    var course: Course = null
    val rs = execute(s"CALL get_course($id);")
    rs.next()
    course = Course (
      id = rs.getInt("id"),
      attributes = CourseAttrs (
        rs.getInt("room"),
        rs.getString("name")
      )
    )
    Ok(NormalizedResponse(course).asJson)
  }

  val addCourse: Endpoint[IO, Json] = post("courses" :: jsonBody[NewNormalizedResponse])
  { resp: NewNormalizedResponse =>
    var course: Course = null
    val rs = execute(s"CALL new_course(${resp.data.attributes.room}, '${resp.data.attributes.name}')")
    rs.next()
    course = Course (
      id = rs.getInt("id"),
      attributes = CourseAttrs (
        rs.getInt("room"),
        rs.getString("name")
      )
    )
    Ok(NormalizedResponse(course).asJson)
  }

  val editCourse: Endpoint[IO, Json] = patch("courses" :: path[Int] :: jsonBody[NormalizedResponse])
  { (id: Int, resp: NormalizedResponse) =>
    var course: Course = null
    val rs = execute(s"CALL edit_course($id, ${resp.data.attributes.room}, '${resp.data.attributes.name}')")
    rs.next()
    course = Course (
      id = rs.getInt("id"),
      attributes = CourseAttrs (
        rs.getInt("room"),
        rs.getString("name")
      )
    )
    Ok(NormalizedResponse(course).asJson)
  }

  val delCourse: Endpoint[IO, Unit] = delete("courses" :: path[Int]) { id: Int =>
    var course: Course = null
    val rs = execute(s"CALL delete_course($id)")
    //rs.next()
    NoContent[Unit]
  }

}
