package CatsContraAndInva
import cats.Contravariant
import cats.Show
import cats.instances.all._
import cats.Monoid
import cats.syntax.all._

object LearningTest extends App{
  val stringShow = Show[String]

//  val symbolShow = Contravariant[Show].
//    contramap(stringShow)((sym: Symbol) => s"'${sym.name}")

  val symbolShow = stringShow.contramap[Symbol](_.name)
  println(symbolShow.show('Cat))

  implicit val symbolMonoid: Monoid[Symbol] =
    Monoid[String].imap(Symbol.apply)(_.name)

  println(Monoid[Symbol].empty)
  println('a |+| 'b |+| 'c)
}
