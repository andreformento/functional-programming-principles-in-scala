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
    def get(col: Int, row: Int): Int = {
      if (col < 0 || col > row) {
        0
      } else {
        pascal(col, row)
      }
    }

    if (r <= 0) {
      1
    } else {
      get(c - 1, r - 1) + get(c, r - 1)
    }
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def validate(count: Int, list: List[Char]): Boolean = {
      if (list.isEmpty) count == 0
      else if (count < 0) false
      else {
        val current = list.head
        val sum = {
          if (current.equals('(')) {
            1
          } else if (current.equals(')')) {
            -1
          } else {
            0
          }
        }

        validate(count + sum, list.tail)
      }
    }
    validate(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty || money < 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
