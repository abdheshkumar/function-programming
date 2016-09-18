package parkar.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abdhesh on 9/6/16.
 */
//Functional style and mutability
class SampleEvenSquare {

    public static void main(String[] arg) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> doubleOfEvenNumber = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                doubleOfEvenNumber.add(number * 2);
            }
        }
        System.out.println(doubleOfEvenNumber);
    }
}

//has anybody wrote like this
/**
 System.out.println(
 numbers.stream()
 .filter(f -> f % 2 == 0)
 .map(e -> e * 2)
 .collect(Collectors.toList())
 );
 */