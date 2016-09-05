package parkar

import scala.io.{Codec, Source}

/**
 * Created by Abdhesh.Kumar on 28-08-2016.
 */
object FileProcessorSequential extends App {
  val start = System.currentTimeMillis()
  val chunkSize = 128 * 1024
  lazy val data = Source.fromFile( """src\main\resources\data\majestic_million.csv""")(Codec("UTF-8"))
    .getLines()
  val counts = data.toVector.grouped(chunkSize).map { lines =>
    lines.foldLeft(0)((sum, line) => sum + line.length)
  }
  println(s"Number of characters in file is: ${counts.sum} ${(System.currentTimeMillis().toDouble - start.toDouble) / 1000}")
}
