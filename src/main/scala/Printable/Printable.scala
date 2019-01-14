trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def print[A](value: A)(implicit printable: Printable[A]): Unit = {
    println(format(value))
  }

  def format[A](value: A)(implicit printable: Printable[A]): String =
    printable.format(value)
}

