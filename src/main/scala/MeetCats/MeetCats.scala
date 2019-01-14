import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import CustomShowInstances._
import java.util.Date

object MeetCats extends App {
  val showInt = Show.apply[Int]
  val showString = Show.apply[String]
  val intAsString: String =
    showInt.show(123)
  val stringAsString: String =
    showString.show("123")
  val cat = Cat("ZYF", 2, "pink")
  val date = new Date()
  println(intAsString)
  println(125632.show)
  println(stringAsString)
  println(cat.show)
  println(date.show)
}