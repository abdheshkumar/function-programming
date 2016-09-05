package parkar.parallel;

import java.util.stream.IntStream;

/**
 * Created by abdhesh on 9/4/16.
 */
public class SampleParallel {

    public static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.range(2, number)
                        .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        int number = 100;
        long start = System.nanoTime();

        double sumOfSqrtsOfPrimes =
                IntStream.rangeClosed(1, number)
                        .boxed()
                        .parallel()
                        .filter(SampleParallel::isPrime)
                        .map(Math::sqrt)
                        .reduce(0.0, Double::sum);

        long end = System.nanoTime();

        System.out.printf("Time Taken: %g sec\n", (end - start) / 1e9);
        System.out.println(sumOfSqrtsOfPrimes);
    }

}
