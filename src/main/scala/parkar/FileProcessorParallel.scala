package parkar

import java.util.concurrent.TimeUnit

import scala.concurrent.forkjoin.ForkJoinPool
import scala.concurrent.{ExecutionContext, Future}
import scala.io.{Codec, Source}
import scala.util.{Failure, Success}

/**
 * Created by Abdhesh.Kumar on 27-08-2016.
 */
object FileProcessorParallel extends App {
  val executor = new ForkJoinPool()
  implicit val context = ExecutionContext.fromExecutor(executor)


  val start = System.currentTimeMillis()
  val chunkSize = 128 * 1024
  lazy val data = Source.fromFile( """src\main\resources\data\majestic_million.csv""")(Codec("UTF-8"))
    .getLines()
  Future.sequence(data.toVector.grouped(chunkSize).map { lines =>
    Future(lines.foldLeft(0)((sum, line) => sum + line.length))
  }).onComplete {
    case Success(counts) => println(s"Number of characters in file is: ${counts.sum} ${(System.currentTimeMillis().toDouble - start.toDouble) / 1000}")
    case Failure(ex) => println(s"There was some problem while reading file:${ex}")
  }
  executor.shutdown()
  executor.awaitTermination(1, TimeUnit.MILLISECONDS)
}
