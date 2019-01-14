import cats.Eq
import cats.instances.int._
import cats.syntax.eq._

val eqInt = Eq[Int]
1 === 2
eqInt.eqv(24, 24)

import cats.instances.option._

(Some(1): Option[Int]) === (None: Option[Int])

import cats.syntax.option._

1.some
1.some === none[Int]

