import cats.instances.function._
import cats.syntax.functor._
import cats.Functor
import com.sun.source.doctree.TextTree
import BinaryTree._
object Test {
  def callByName(i : => Int) =
    println("callByName")

  def callByValue(i: Int) =
    println("callByValue")

  def infiniteLoop: Int = {
    while(true) {}
    return 1
  }

}
object CatsFuncObject extends App{
  val func1: Int => Double = (x: Int) => x.toDouble
  val func2: Double => Double = (x: Double) => x * 2
  (func1 andThen func2)(1)
  println ((func1 map func2)(1))
  Test.callByName(Test.infiniteLoop)
//  Test.callByValue(Test.infiniteLoop)
  println(branch(10.leaf, 20.leaf).map(_ * 2).branchWith(1.leaf))
}
