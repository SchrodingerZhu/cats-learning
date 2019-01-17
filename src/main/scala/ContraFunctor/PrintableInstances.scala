package ContraFunctor
object PrintableInstances {
  implicit val intPrintable: Printable[Int] =
    new Printable[Int] {
      override def format(value: Int): String = value.toString
    }
  implicit val stringPrintable: Printable[String] =
    new Printable[String] {
      override def format(value: String): String = value
    }
  implicit def somePrintable[B](implicit p: Printable[B]) =
    p.contramap[Some[B]](_.get)
}
