package MonoidAndSemigroup

import cats.Monoid
import cats.instances.all._
import cats.syntax.all._

object CatsMonoid {
  def add(items: List[Int]): Int =
    items.foldLeft(Monoid[Int].empty)(_ |+| _)
}
