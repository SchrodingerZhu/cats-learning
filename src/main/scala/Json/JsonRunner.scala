import JsonSyntax._
import JsonWriterInstances._

import scala.language.implicitConversions

object JsonRunner extends App {
  println(MyJson.toJson("Kivi is currently single."))
  val x = Person("Kivi", "Kivi@程序员.中文")
  println(x.toJson)
  val y = Account(123456, x)
  println(y.toJson)
  val z: Option[Account] = Some(y)
  val a: Option[Account] = None
  println(MyJson.toJson(z) + "\n" + a.toJson)
}
