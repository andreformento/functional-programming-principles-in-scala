import scala.annotation.tailrec
// https://www.coursera.org/learn/progfun1/lecture/51t1e/lecture-1-7-tail-recursion

object session {
  // a % b
  14 % 21
  21 % 14
  7 % 21
  7 % 14
  7 % 7

  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  gcd(14, 21)

  def factorialWithoutTailRec(n: Int): Int =
    if (n == 0) 1
    else n * factorialWithoutTailRec(n - 1)

  factorialWithoutTailRec(4)

  def factorial(n: Int): Int = {
    @tailrec
    def loop(acc: Int, x: Int): Int =
      if (x == 0) acc
      else loop(x * acc, x - 1)

    loop(1, n)
  }

  factorial(4)

}
