package com.formento.coursera.lecture01

/*
  cd <base project dir>
  scalac -d temp src/main/scala/com/formento/coursera/lecture01/Recursion.scala
  scala -cp temp com.formento.coursera.lecture01.Recursion
*/
object Recursion {
  def main(args: Array[String]): Unit = {
    println(args.length)

    args.foreach(a => {
      println(a.getClass.getName)
      println(a.toInt)
      println(a.toInt.getClass.getName)
    })

  }
}
