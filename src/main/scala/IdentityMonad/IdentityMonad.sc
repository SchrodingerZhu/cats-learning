import scala.language.higherKinds
import cats.Monad
import cats.syntax.all._
import cats.instances.all._


def sumSquare[F[_] : Monad](a: F[Int], b: F[Int]): F[Int] =
  for {
    x <- a
    y <- b
  } yield x * x + y * y;

val a = List(1)
val b = List(2)

sumSquare(a, b)

import cats.Id
sumSquare(3: Id[Int], 4: Id[Int])
