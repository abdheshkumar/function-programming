package parkar.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by abdhesh on 9/6/16.
 */

//Don't use mutable in lambda functions
class SampleMutable {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[] factor = new int[]{2};
        Stream<Integer> stream = numbers
                .stream()
                .map(f -> f * factor[0]);
        factor[0] = 0;
        stream.forEach(System.out::println);

    }
}