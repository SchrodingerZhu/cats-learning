val either1: Either[String, Int] = Right(10)
val either2: Either[String, Int] = Right(32)

for {
  a <- either1
  b <- either2
} yield a + b

import cats.syntax.either._
val either3 = 3.asRight[String]

def countPositive(nums: List[Int]) =
  nums.foldLeft(0.asRight[String]) {
    (accumulator, num) =>
      if(num > 0) {
        accumulator.map(_ + 1)
      } else {
        if (accumulator.isRight) {
          Left(s"Negative at ${accumulator.right.get}. Stopping!")
        } else {
          accumulator
        }
      }
  }

countPositive(List(1, 2, 3, 4, 5))

countPositive(List(1, 1, 2, -1))

Either.catchOnly[NumberFormatException]("foo".toInt)

Either.catchNonFatal(sys.error("JustATest"))

Either.fromTry {
  scala.util.Try {
    "foo".toInt
  }
}

Either.fromOption[String, Int](None, "Test")

"Error".asLeft[Int].getOrElse(0)
"Error".asLeft[Int].getOrElse(2.asRight[String])

-1.asRight[String].ensure("Must be non-negative!")(_ > 0)

"error".asLeft[Int].recover {
  case _: String => -1
}

"foo".asLeft[Int].leftMap(_.reverse)
6.asRight[String].bimap(_.reverse, _ * 7)
"bar".asLeft[Int].bimap(_.reverse, _ * 7)

val test = 123.asRight[String]
123.asRight[String].swap


// Error Handling
for {
  a <- 1.asRight[String]
  b <- 0.asRight[String]
  c <- if(b == 0) "DIV0".asLeft[Int]
  else (a/ b).asRight[String]
} yield c * 100

var t = 10;
while(t > 0) {
  println("喵呜！")
  t = t - 1
}



