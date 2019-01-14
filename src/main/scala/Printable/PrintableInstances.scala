import PrintableSyntax._
object PrintableInstances {
  implicit val stringPrintable: Printable[String] =
    new Printable[String] {
      override def format(value: String): String = value
    }

  implicit val intPrintable: Printable[Int] =
    new Printable[Int] {
      override def format(value: Int): String = value.toString
    }

  implicit val catPrintable: Printable[Cat] =
    new Printable[Cat] {
      override def format(value: Cat): String = {
        Printable.format(value.name) +
        " is a " +
        Printable.format(value.age) +
        " year-old " +
        Printable.format(value.color) +
        " cat."
      }
    }
}
