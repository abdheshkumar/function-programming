package parkar

import scala.collection.parallel.mutable.ParArray

/**
 * Created by Abdhesh.Kumar on 26-08-2016.
 */
object Benchmark extends App {

  lazy val pc = ParArray.range(1, 100000000)
  /*pc.tasksupport = new ForkJoinTaskSupport(
    new scala.concurrent.forkjoin.ForkJoinPool(10))*/
  println(time(pc.foreach(_ + 1)))

  def time(block: => Unit) {
    val start = System.currentTimeMillis()
    block
    val end = System.currentTimeMillis()
    println("time: " + (end - start))
  }
  //lazy val pcs = Range(1, 100000000)

  //println(time(pcs.foreach(_ + 1)))

}
