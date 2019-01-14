import java.util.Date

import cats.Eq
import cats.instances.long._
import cats.syntax.eq._

object CustomEqInstances {
  implicit val dateEq: Eq[Date] =
    Eq.instance[Date] {
      (date1, date2) => date1.getTime === date2.getTime
    }
}
