package com.practice.learning.part1basics

object DefaultArgs extends App {

  def savePicture(format: String = "png", width: Int, height: Int): Unit =
    println("Saving... " + format + "-" + width + "-" + height) //Check that format param is default.

  savePicture(width = 1920, height = 1080) //We can set the name of the params we are passing.
  savePicture(height = 1080, width = 1920, format = "jpg") // Also we can pass the params in different order if we named them.

}
