package ContraFunctor
import Printable._
import PrintableInstances._
object ContraFunctor extends App {
  println("This is a test for ContraFunctor.")
  val testSome = Some(Some(Some("MATH")))
  println(Printable.format(testSome))
}
