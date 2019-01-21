package Monad

object OptionTest extends App {
  def parseInt(str: String): Option[Int] =
    scala.util.Try(str.toInt).toOption

  def divide(a: Int, b: Int): Option[Int] =
    if(b == 0) None else Some(a / b)

  def stringDivideBy(aStr: String, bStr: String): Option[Int] =
    parseInt(aStr).flatMap {
      aNum => parseInt(bStr).flatMap {
        bNum => divide(aNum, bNum)
      }
    }

  def simpleStringDivide(aStr: String, bStr: String): Option[Int] =
    for {
      a <- parseInt(aStr)
      b <- parseInt(bStr)
      ans <- divide(a, b)
    } yield ans

  println(stringDivideBy("88", "8"))
  println(simpleStringDivide("88", "8l"))

  println(for {
    x <- (1 to 3).toList
    y <- (2 to 4).toList
  } yield (x, y))



}
