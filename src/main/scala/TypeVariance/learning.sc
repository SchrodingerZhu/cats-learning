trait Shape

case class Circle(radius: Double) extends Shape

case class Square(a: Double) extends Shape

val circles: List[Shape] = List(Circle(1))
val shapeWriter: JsonWriter[Shape] =
  new JsonWriter[Shape] {
    override def write(value: Shape): MyJson = JsString(value.toString)
  }


