
// 1.) load libraries / jar's i.e. from 
// https://mvnrepository.com/artifact/org.scalaz/scalaz-core_2.12/7.2.15
// https://mvnrepository.com/artifact/com.github.mpilquist/simulacrum_2.12/0.11.0
//https://mvnrepository.com/artifact/com.chuusai/shapeless_2.12/2.3.2

// 2.) add to project, then Build path -> Configure libraries


import scalaz._, Scalaz._
import simulacrum._
import stalactite._
import concurrent._

trait TerminalSync {
    def read(): String
    def write(t: String): Unit
  }
  
  trait TerminalAsync {
    def read(): Future[String]
    def write(t: String): Future[Unit]
  }


object app extends App {
  
def max(x: Int, y: Int): Int = {
if (x > y) x
else y
}


def sumOfSquares(x: Int, y: Int): Int = {
  val x2 = x * x
  val y2 = y * y
  x2 + y2
}


def sort(xs: Array[Int]): Array[Int] = {
  if (xs.length <= 1) xs
  else {
    val pivot = xs(xs.length / 2)
    Array.concat(
    sort(xs filter (pivot >)),
          xs filter (pivot ==),
          sort(xs filter (pivot <)))
  }
}

val us =  Array(1, 99, 3, 8,33, 2)

println(sort(us).mkString("-"))




val m = max(4, 9)
val z : Int = 1234

println(m)
println(z)

println("hello world".length() )

val n = 45
println( s"We have $n apples")

val html = """
              <form id="daform">
                <p>Press belo', Joe</p>
                <input type="submit">
              </form>"""

println( html)

println(sumOfSquares(3, 5))


def addWithDefault(x: Int, y: Int = 5) = x + y
println(addWithDefault(1, 2)) // => 3
println(addWithDefault(1))

// Anonymous functions look like this:
(x: Int) => x * x


val sq: Int => Int = x => x * x

// Anonymous functions can be called as usual:
println(sq(10))   // => 100


val addOne: Int => Int = _ + 1
val weirdSum: (Int, Int) => Int = (_ * 2 + _ * 3)

addOne(5)      // => 6
weirdSum(2, 4) // => 16

// https://learnxinyminutes.com/docs/scala/

val r = 1 to 5
r.foreach(println)
r foreach println
(5 to 1 by -1) foreach (println)



}