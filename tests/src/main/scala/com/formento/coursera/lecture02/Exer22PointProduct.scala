package com.formento.coursera.lecture02

/*
* Video
* Lecture 2.2 - Currying
* Time: 7:51
*
* 1. Write a product function that calculates the product
*    of the values of a function for the points on a given interval.
*
* 2. Write the factorial in terms of product.
*
* 3. Can you write a more general function, which
*    generalizes both sum and product?
* */
object Exer22PointProduct {

  def main(args: Array[String]): Unit = {
    /*
    * 2 * 2 =   4
    * 3 * 3 =   9
    * 4 * 4 =  16
    *         576
    * */
    println("Exer1 - product of points: " + exer1CalculateProductFromPoints(2, 3))
    println("-----------------------------")

    /*
     * 0 1 2 3 4 5  6
     * 1 1 2 3 5 8 13
     */
    println("Exer2 -                1 : " + exer2Factorial(0))
    println("Exer2 - factorial (0)  1 : " + exer2Factorial(0))
    println("Exer2 - factorial (1)  1 : " + exer2Factorial(1))
    println("Exer2 - factorial (2)  2 : " + exer2Factorial(2))
    println("Exer2 - factorial (3)  6 : " + exer2Factorial(3))
    println("Exer2 - factorial (4) 24 : " + exer2Factorial(4))
    println("-----------------------------")

    println("Exer3 - factorial (0)  1 : " + exer3Generalizes(0))
    println("Exer3 - factorial (1)  1 : " + exer3Generalizes(1))
    println("Exer3 - factorial (2)  2 : " + exer3Generalizes(2))
    println("Exer3 - factorial (3)  6 : " + exer3Generalizes(3))
    println("Exer3 - factorial (4) 24 : " + exer3Generalizes(4))
  }

  def exer1CalculateProductFromPoints(value: Int, interval: Int): Int = {
    def sumProductPoints(f: Int => Int)(count: Int, accumulator: Int)(x: Int): Int =
      if (count <= 0) accumulator
      else sumProductPoints(f)(count - 1, f(x) * accumulator)(x + 1)

    sumProductPoints(x => x * x)(interval, 1)(value)
  }

  def fibonacci(num: Int): Int = {
    def otherInt(a: Int, b: Int, count: Int): Int = {
      val sum = a + b
      val nextCount: Int = count - 1
      if (nextCount <= 0) sum
      else otherInt(b, sum, nextCount)
    }
    otherInt(0, 1, num)
  }

  // Write the factorial in terms of product.
  def exer2Factorial(num: Int): Int = {
    def factorial(x: Int, accumulator: Int): Int = {
      val next: Int = x + 1
      if (next > num) accumulator
      else factorial(next, next * accumulator)
    }
    factorial(0, 1)
  }

  // Can you write a more general function, which generalizes both sum and product?
  def exer3Generalizes(num: Int): Int = {
    def sum(f: (Int, Int) => Int, x: Int, accumulator: Int): Int = {
      val next: Int = x + 1
      if (next > num) accumulator
      else sum(f, next, f(next, accumulator))
    }

    def product(x: Int, y: Int): Int = x * y

    sum(product, 0, 1)
  }

}
