package MonoidAndSemigroup.selfwritten

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid
}


object MonoidInstances {
  implicit def setUnionMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def empty: Set[A] = Set.empty[A]

      override def combine(x: Set[A], y: Set[A]): Set[A] = x union y
    }
}

import MonoidInstances._

object Learning extends App {
  val intSetMonoid = Monoid[Set[Int]]
  println(intSetMonoid.combine(Set(1, 2), Set(2, 5)))
}