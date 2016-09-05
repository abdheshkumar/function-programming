package parkar.parallel

/**
  * Created by abdhesh on 9/4/16.
  */
object SampleParallelScala {

  def isPrime(number: Int) =
    number > 1 && Stream.range(2, number)
      .forall(number % _ != 0)


  def main(args: Array[String]) {
    val number = 101
    val start = System.nanoTime()

    val sumOfSqrtsOfPrimes =
      Stream.range(1, number)
        .filter(isPrime)
        .map(f => math.sqrt(f))
        .sum

    val end = System.nanoTime()

    printf("Time Taken: %g sec\n", (end - start) / 1e9)
    println(sumOfSqrtsOfPrimes)
  }

}
