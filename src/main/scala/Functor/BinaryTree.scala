import cats.Functor
import cats.syntax.all._
import cats.instances.all._
import scala.language.higherKinds
sealed trait BinaryTree[+A]

final case class Branch[+A](left: BinaryTree[A], right: BinaryTree[A])
  extends BinaryTree[A]

final case class Leaf[+A](value: A) extends BinaryTree[A]

object BinaryTree {
  implicit val binaryTreeFunctor: Functor[BinaryTree] =
    new Functor[BinaryTree] {
      override def map[A, B] (binaryTree: BinaryTree[A])(func: A => B): BinaryTree[B] =
        binaryTree match {
          case Branch(l, r) =>
            Branch(map(l)(func), map(r)(func))
          case Leaf(value) =>
            Leaf(func(value))
        }
    }
  implicit class leafOps[A](value: A) {
    def leaf: BinaryTree[A] = Leaf[A](value)
  }
  implicit class branchOps[A](value: BinaryTree[A]) {
    def branchWith(another: BinaryTree[A]): BinaryTree[A] = Branch[A](value, another)
  }
  def branch[A](left: BinaryTree[A], right: BinaryTree[A]): BinaryTree[A] =
    Branch[A](left, right)
}

