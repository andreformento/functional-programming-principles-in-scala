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
