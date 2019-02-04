import cats.syntax.all._
trait LoginError extends Product with Serializable

final case class UserNotFound(username: String)
  extends LoginError

final case class PasswordIncorrect(username: String)
  extends LoginError

case object UnexpectedError extends LoginError

case class User(username: String, password: String)


object TestEither {
  type LoginResult = Either[LoginError, User]
  def handleError(error: LoginError): Unit =
    error match {
      case UserNotFound(u) =>
        println(s"User not found: $u")

      case PasswordIncorrect(u) =>
        println(s"Password incorrect: $u")

      case UnexpectedError =>
        println(s"Unexpected error")
    }
}

object RunEither extends App{
  type LoginResult = Either[LoginError, User]
  val result1: LoginResult = User("dave", "passw0rd").asRight

  val result2: LoginResult = UserNotFound("dave").asLeft

  result1.fold(TestEither.handleError, println)
  result2.fold(TestEither.handleError, println)
}