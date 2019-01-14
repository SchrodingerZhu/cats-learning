import CustomEqInstances._
import cats.Eq
import cats.instances.int._
import cats.instances.option._
import cats.syntax.eq._
import cats.syntax.option._
object EqRunner extends App {
  val eqInt = Eq[Int]
  val testDate1 = new java.util.Date()
  println(243 === 123)
  val testDate2 = new java.util.Date()
  println(243 =!= 123)
  println(testDate1 === testDate2)

  //You can also play with options
  println(testDate1.some === testDate2.some)
}
