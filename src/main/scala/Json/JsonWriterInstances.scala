import JsonSyntax._

object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      override def write(value: String): MyJson = JsString(value)
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      override def write(value: Person): MyJson =
        JsObject(Map(
          "name" -> JsString(value.name),
          "email" -> JsString(value.email)
        ))
    }

  implicit val accountWriter: JsonWriter[Account] =
    new JsonWriter[Account] {
      override def write(value: Account): MyJson =
        JsObject(Map(
          "id" -> JsInt(value.id),
          "owner" -> value.owner.toJson
        ))
    }

  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
    new JsonWriter[Option[A]] {
      override def write(value: Option[A]): MyJson = value match {
        case Some(subValue) => writer.write(subValue)
        case None => JsNull
      }
    }
}