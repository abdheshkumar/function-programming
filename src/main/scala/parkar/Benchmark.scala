package parkar

import scala.collection.parallel.mutable.ParArray

/**
 * Created by Abdhesh.Kumar on 26-08-2016.
 */
object Benchmark extends App {

  import scala.collection.parallel._

  val pc = ParArray.range(1, 10000000)
  pc.tasksupport = new ForkJoinTaskSupport(
    new scala.concurrent.forkjoin.ForkJoinPool(10))
  println(time(pc.map(_ + 1)))

  def time(block: => Unit) {
    val start = System.currentTimeMillis()
    block
    val end = System.currentTimeMillis()
    println("time: " + (end - start))
  }

}
