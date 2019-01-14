sealed trait MyJson

trait JsonWriter[A] {
  def write(value: A): MyJson
}

final case class JsObject(get: Map[String, MyJson]) extends MyJson

final case class JsString(get: String) extends MyJson

final case class JsInt(get: Int) extends MyJson

case object JsNull extends MyJson

object MyJson {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): MyJson =
    w.write(value)
}