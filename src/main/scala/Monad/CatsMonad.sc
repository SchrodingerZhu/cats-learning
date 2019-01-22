import cats.Monad
import cats.instances.all._

import scala.concurrent.Await

val opt1 = Monad[Option].pure(3)

val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))

val opt3 = Monad[Option].map(opt2)(a => 100 * a)

val list1 = Monad[List].pure(3)

val list2 = Monad[List].
  flatMap(List(1, 2, 3))(a => List(a, a * 100))

val list3 = Monad[List].
  map(list2)(a => a + 900)

Monad[Vector].flatMap(Vector(1, 2, 3)) (a => Vector(a, a + 999))

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

val fm = Monad[Future]

val future = fm.flatMap(fm.pure(1))(x => fm.pure(x + 55))

Await.result(future, 1.second)

import cats.syntax.all._

1.pure[List]
1.pure[Option]

import scala.language.higherKinds

def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
  a.flatMap(x => b.map(y => x * x + y * y))

sumSquare(3.some, 4.some)

sumSquare(Vector(1, 2, 3), Vector(4, 5))

def sumSquareV2[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
  for {
    x <- a
    y <- b
  } yield (x * x) + (y * y)

sumSquareV2(List(1, 4, 3), List(5, 5, 5))

