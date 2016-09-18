package example

/**
 * Created by Abdhesh.Kumar on 18-09-2016.
 */
object Solution1 {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val a = Array.ofDim[Int](n, n)
    for (a_i <- 0 to n - 1) {
      for (a_j <- 0 to n - 1) {
        val b = sc.nextInt()
        println("::::"+b)
        a(a_i)(a_j) = b
      }
    }

    def getForwardDiagonal1(x: Array[Array[Int]]) = {
      for {row <- x.zipWithIndex
           el <- row._1.zipWithIndex
           if row._2 == el._2
      } yield (el._1)
    }

    def reverseDiagonalElements(xs: Array[Array[Int]]) = {
      def extract(i: Int, j: Int): Array[Int] = (i, j) match {
        case (a, b) if a < 0 || b < 0 || a >= xs.length => Array()
        case _ => Array(xs(i)(j)) ++ extract(i + 1, j - 1)
      }
      extract(0, xs(0).length - 1)
    }

    val diagonal1 = getForwardDiagonal1(a)
    val diagonal2 = reverseDiagonalElements(a)
    println(math.abs(diagonal1.sum - diagonal2.sum))
  }
}