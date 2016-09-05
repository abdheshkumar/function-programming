package parkar.parallel

/**
  * Created by abdhesh on 9/4/16.
  */

object SampleScala {
  var sumOfSqrtsOfPrimes = 0.0

  def isPrime(number: Int): Boolean =
    number > 1 && (2 until number)
      .forall(number % _ != 0)

  def main(args: Array[String]) {
    val number = 100
    val start = System.nanoTime()

    for (i <- 1 to number) {
      if (isPrime(i)) {
        sumOfSqrtsOfPrimes += math.sqrt(i)
      }
    }

    val end = System.nanoTime()

    printf("Time Taken: %g sec\n", (end - start) / 1e9)
    println(sumOfSqrtsOfPrimes)
  }
}
