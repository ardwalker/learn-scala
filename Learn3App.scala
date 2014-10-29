

/**
 * An example strategy in Scala
 */

class Learn3App {
}

object Learn3App extends Learn3App {
  type Strategy = (Int, Int) => Int

  val add: Strategy       = _ + _
  val subtract: Strategy  = _ - _
  def multiply: Strategy  = _ * _
  def divide: Strategy    = _ / _

  def execute(strategy: Strategy, x: Int, y: Int) = strategy(x, y)

  def main(args: Array[String]) {
    println("Executing add strategy:      " + execute(add, 1, 2))
    println("Executing subtract strategy: " + execute(subtract, 12, 8))
    println("Executing multiply strategy: " + execute(multiply, 5, 8))
    println("Executing divide strategy:   " + execute(divide, 4, 2))
  }
}

