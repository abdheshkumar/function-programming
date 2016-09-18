package example

/**
 * Created by Abdhesh.Kumar on 18-09-2016.
 */
object Solution2Implicits {
  implicit def scalaFormatter(x: Option[Double]): String = x match {
    case Some(v) => "%.6f".format(v)
    case None => "%.6f".format(0.0)
  }
}

object Solution2 extends App {

  import Solution2Implicits._

  val arr = Array(55, 48, 48, 45, 91, 97, 45, 1, 39, 54, 36, 6, 19, 35,
    66, 36, 72, 93, 38, 21, 65, 70, 36, 63, 39, 76, 82, 26, 67, 29, 24, 82,
    62, 53, 1, 50, 47, 65, 67, 19, 66, 90, 77)

  /*def f = (x: Int) => x match {
    case _ if x > 0 => 1
    case _ if x < 0 => -1
    case _ if x == 0 => 0
  }*/
  def f = (x: Int) => {
    if (x > 0) 1
    else if (x < 0) -1
    else 0
  }

  /*
    val groupedElements: Map[Int, Double] =
      arr.groupBy(f).
        map((k => (k._1, k._2.length * 1.0 / arr.length)))
  */

  val numberOfItems = arr.length
  val groupedElements =
    arr.groupBy(f)
      .map {
      case (key, value) => (key, value.length * 1.0 / numberOfItems)
    }

  val d0: String = groupedElements.get(1)
  val d1: String = groupedElements.get(-1)
  val d2: String = groupedElements.get(0)
  println(d0)
  println(d1)
  println(d2)
}
