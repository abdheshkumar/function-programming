package example

/**
  * Created by abdhesh on 9/13/16.
  */
//https://www.hackerrank.com/challenges/diagonal-difference?h_r=next-challenge&h_v=zen
object DiagonalDifference extends App {

  val array = Array(
    Array(11, 2, 4),
    Array(4, 5, 6),
    Array(10, 8, -12)
  )

  val diagonalSum = array.zipWithIndex
    .map {
      case (arrayWithElements, index) =>
        arrayWithElements(index) -> arrayWithElements(arrayWithElements.length - 1 - index)
    }
  val (primaryDiagonalSum, secondaryDiagonalSum) =
    diagonalSum.toList.fold((0, 0)) {
      case ((a1, a2), (b1, b2)) => (a1 + b1) -> (a2 + b2)
    }
  println(math.abs(primaryDiagonalSum - secondaryDiagonalSum))
}
