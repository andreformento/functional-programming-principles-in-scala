package exercises

// https://www.coursera.org/learn/progfun1/lecture/f6IQm/lecture-1-4-conditionals-and-value-definitions
object Lecture_1_4_conditionals_and_value_definitions {

  def eagerFun(a: Int, b: Int) ={
    1
  }

  def lazyFun(a: => Int, b: => Int) ={
    2
  }

  def incAndCalculate(x: Int) = {
    val result = x + 1
    println(result)
    result
  }

  def main(args: Array[String]): Unit = {
    println("eagerFun " + eagerFun(incAndCalculate(10), incAndCalculate(15)))
    println("lazy " + lazyFun(incAndCalculate(20), incAndCalculate(25)))
  }

}

object lecture_1_4_conditionals_and_value_definitions {

  def main(args: Array[String]): Unit = {
    val a = Seq(1, 2, 3, 4).
      map(x => x + 10).
      map(_ * 2).
      reduce((a, b) => a + b)
    println(a)


    val x = if (false) {
      println("is true")
      1
    } else {
      println("is false")
      0
    }
    println(x)
  }

}

//https://www.coursera.org/learn/progfun1/lecture/rBgEI/lecture-1-6-blocks-and-lexical-scope