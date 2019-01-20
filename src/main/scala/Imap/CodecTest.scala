package Imap
import Codec._
import CodecInstances._
object Imap extends  App{
  println(encode(123))
  decode[Int]("123")
  println(decode[Some[Int]]("123"))
}