package com.practice.learning.part3fp

object MapFlatMapFilter extends App {

  val list = List(1, 2, 3, 4)
  println(list.head)
  println(list.tail)
  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))
  //filter
  println(list.filter(_ % 2 == 0))
  //flatMap
  val toPair = (x: Int) => List(x, (x + 1))
  println(list.flatMap(toPair))

  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val combinations = list.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  list.foreach(println)

  //for-comprehensions
  val forCombinations = for { //in this way we can do the same than flatMap for val combinations
    n <- list
    c <- chars
    colors <- colors
  } yield "" + c + n + "-" + colors
  println(forCombinations)

  val forCombinations2 = for {
    n <- list if n % 2 == 0
    c <- chars
    colors <- colors
  } yield "" + c + n + "-" + colors
  println(forCombinations2)

  //syntax overload
  val mapped = list.map { x =>
    x * 2
  }
  println(mapped)

  for (
    xd <- chars;
    a <- colors
  ) yield {
    println(xd + "//" + a)
  }

  val isPositive = List(true, true, true)
  val nums = List(2, 1, 4)

  val a = (nums.zipWithIndex).filter(x => isPositive(x._2))
  println(a.map(_._1))

  val awa = Array(2,null,1,4,11,null,1)
  println(awa.toString)

  val lista = List()
  val k = lista:+(true,1)
  println(k(0))

  val indexes = Array(1,0)
  val nums2 = Seq(2, 1, 4)
  val nums3 = nums2.zipWithIndex.filterNot(b => indexes.contains(b._2))

  println(nums3.map(_._1 + 1))

  val ada =
    for (num <- nums)
      yield {
        num
      }

  var nums7 = Seq(1, 2, 3)
  val nums77 = Seq(5,2, 1, 4, 10)
  println(nums77.filterNot(b => nums7.contains(b)))

  val row1 = Seq(1,2,3,4,5,6)
  val row2 = Seq(7,8,9,10,11,12)
  val row3 = Seq(13,14,15,16,17,18)
  val rows = Seq(row1, row2, row3)

  val f = nums77.zipWithIndex.filterNot(b => nums7.contains(b._2))
  println(f.map(_._1))

  println(
    if (nums7.size > 3)
      nums7(2)
    else None
  )
  println(nums7.size)

  println(nums7.empty)
  nums7 = nums7.empty
  println(nums7)

  val row4 = Seq(0,0,0,0,0,0)
  println(! row4.forall(_ == 0))

  val xd = "asd"
  println(xd.substring(0, 0) + "Hola")

  val uwu = Map("a" -> Seq(None,None,None, None))
  println(uwu.filterNot(x => x._2.forall(_.isEmpty)))

  var xd2 = 0
  row1.foreach( num =>
    if (num == 7)
      xd2 = 27
  )

  println(xd2)
}
