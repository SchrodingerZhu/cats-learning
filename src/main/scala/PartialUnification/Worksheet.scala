package PartialUnification
import cats.Functor
import cats.instances.function._
import cats.syntax.functor._

//must enable -Ypartial-unification
object Test extends App {
  val func1 = (x: Int) => x.toDouble
  val func2 = (y: Double) => y * 2

  val func3 = func1 map func2
  type F[A] = Int => A
  val functor = Functor[F]
  println(functor)
}