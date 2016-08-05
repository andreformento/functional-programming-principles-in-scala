package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (r <= 0) {
      return 1
    }

    def get(col: Int, row: Int): Int = {
      if (col < 0 || col > row) {
        0
      } else {
        pascal(col, row)
      }
    }

    get(c - 1, r - 1) + get(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def validate(count: Int, list: List[Char]): Boolean = {
      if (list.isEmpty) return count == 0
      else if (count < 0) return false

      val current = list.head
      var sum: Int = 0

      if (current.equals('(')) {
        sum = 1
      } else if (current.equals(')')) {
        sum = -1
      }
      validate(count + sum, list.tail)
    }
    validate(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def sumList(accumulator: Int, list: List[Int]): Int = {
      if (list.isEmpty) return accumulator
      sumList(accumulator + list.head, list.tail)
    }


    ???
  }
}
