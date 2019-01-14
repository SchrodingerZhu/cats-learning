import PrintableInstances._
import PrintableSyntax._

object PrintableRunner extends App {
  val cat = Cat("Kivi", 2, "blue")
  val a: Int = 1
  cat.print
  a.print
}
