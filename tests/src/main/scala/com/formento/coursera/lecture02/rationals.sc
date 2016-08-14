import com.formento.coursera.lecture02.Rational

val rational1By2: Rational = new Rational(1, 2)
val rational2by3: Rational = new Rational(2, 3)
rational1By2.add(rational2by3)
rational1By2.subtract(rational2by3)
rational1By2.neg

val x: Rational = new Rational(1, 3)
val y: Rational = new Rational(5, 7)
val z: Rational = new Rational(3, 2)
x.add(y).mul(z)
x.subtract(y).subtract(z)
y.add(y)