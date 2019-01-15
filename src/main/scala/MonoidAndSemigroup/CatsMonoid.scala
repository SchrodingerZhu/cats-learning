package MonoidAndSemigroup

import cats.Monoid
import cats.instances.all._
import cats.syntax.all._

object CatsMonoid {
  /*
   *
   * def add(items: List[Int]): Int =
   * items.foldLeft(Monoid[Int].empty)(_ |+| _)
   *
   *
   */
  // With context bound syntax
  def add[A: Monoid](items: List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)

}

object MonoidAndSemigroup extends App{
  println(CatsMonoid.add(List(1, 2, 3, 4)))
  val listOfIntOptions = List(Some(1), None, Some(5))
  println(CatsMonoid.add(listOfIntOptions))
  println(Set(0, 1) |+| Set(9, 0))
}