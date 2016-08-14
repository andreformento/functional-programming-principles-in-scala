package com.formento.coursera.lecture02

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be non zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x

  def denom = y

  def add(that: Rational) =
    new Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom
    )

  def subtract(that: Rational) = add(that.neg)

  def mul(that: Rational) =
    new Rational(
      this.numer * that.numer,
      this.denom * that.denom
    )

  def neg = new Rational(-numer, denom)

  def less(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this.less(that)) that
    else this


  override def toString: String = {
    val g: Int = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}
