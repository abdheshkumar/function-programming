package parkar.parallel;

import java.util.stream.IntStream;

/**
 * Created by abdhesh on 9/4/16.
 */
public class SampleFunctionalStyle {

    private static double sumOfSqrtsOfPrimes = 0.0;

    public static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.range(2, number)
                        .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        int number = 500000;
        long start = System.nanoTime();

        IntStream.rangeClosed(1, number)
                .boxed()
                .filter(SampleFunctionalStyle::isPrime)
                .map(Math::sqrt)
                .forEach(value -> sumOfSqrtsOfPrimes += value); //This is bad

        long end = System.nanoTime();

        System.out.printf("Time Taken: %g sec\n", (end - start) / 1e9);
        System.out.println(sumOfSqrtsOfPrimes);
    }
}
