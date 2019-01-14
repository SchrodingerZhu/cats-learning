import java.util.Date

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.all._

object CustomShowInstances {
  //Method One
  implicit val dateShow: Show[Date] =
    new Show[Date] {
      override def show(t: Date): String =
        s"${t.getTime}ms since the epoch."
    }

  //Method Two, Simplified
  implicit val dataShow: Show[Cat] =
    Show.show(cat => cat.name.show
      + " is a " + cat.age.show
      + " year-old "
      + cat.color.show
      + " cat."
    )
}
