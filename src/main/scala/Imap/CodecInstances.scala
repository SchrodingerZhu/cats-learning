package Imap

object CodecInstances {
  implicit val stringCodec: Codec[String] =
    new Codec[String] {
      override def encode(value: String): String = value
      override def decode(value: String): String = value
    }

  implicit val intCodec: Codec[Int] =
    stringCodec.imap(_.toInt, _.toString)

  implicit val booleanCodec: Codec[Boolean] =
    stringCodec.imap(_.toBoolean, _.toString)

  implicit def someCodec[A](implicit codec: Codec[A]): Codec[Some[A]] =
    codec.imap[Some[A]](Some(_), _.value)
}
