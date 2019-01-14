object PrintableSyntax {

  implicit class PrintableOps[A](value: A) {
    def print(implicit printable: Printable[A]): Unit =
      Printable.print(value)

    def format(implicit printable: Printable[A]): String =
      Printable.format(value)
  }

}
