package Monad
import scala.language.higherKinds
trait Monad[F[_]] {
  def pure[A](value: A): F[A]
  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]
  def map[A, B](value: F[A])(func: A => B): F[B] =
    flatMap(value)(func andThen pure[B])
}
object MonadInstances{
  implicit val optionMonad: Monad[Option] =
    new Monad[Option] {
      override def pure[A](value: A): Option[A] = Some(value)

      override def flatMap[A, B](value: Option[A])(func: A => Option[B]): Option[B] =
        value match {
          case Some(a) => func(a)
          case None => None
        }
    }

  implicit val listMonad: Monad[List] =
    new Monad[List] {
      override def pure[A](value: A): List[A] = List(value)

      override def flatMap[A, B](value: List[A])(func: A => List[B]): List[B] =
        value match {
          case a::tail => func(a):::flatMap(tail)(func)
          case List() => List()
          case Nil => Nil
        }
    }
}

object SelfTest extends App {
  val m = MonadInstances.listMonad
  val func = (x: Int) => List[Int](x * 80)
  val func2 = (x: Int) => List[Int](x * 123)
  assert(m.flatMap(m.pure(312))(func) == func(312))
  assert(m.flatMap(m.flatMap(m.pure(123))(func))(func2)
    == m.flatMap(m.pure(123))(x => m.flatMap(func(x))(func2)))
  println(m.flatMap(m.flatMap(List(123, 312))(func))(func2))
  println(m.flatMap(List(123, 312))(x => m.flatMap(func(x))(func2)))
}
