package algo.week03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfArrayElements {

      /*
    Write a function that takes a String array as parameter and returns a map object that contains each element of array as key and their occurrence counts as value.
    For calculating occurrence, array elements should be checked by regarding case sensitivity.
    Order is not important.
    EXAMPLE:
    Input: {"Apple", "Banana", "apple", "Cherry", "Apple"}
    Output: returning map elements: {Apple=2, apple=1, Cherry=1, Banana=1}
     */

    public static void main(String[] args) {
        String[] strings = {"Apple", "Banana", "apple", "Cherry", "Apple"};
        String[] strings2 = {"Apple", "Banana", null, "Cherry", "Apple"};
        System.out.println(solutionWithStream1(strings));
        System.out.println(solutionWithStream1(strings2));
        System.out.println(solutionWithStream1(new String[1]));
        System.out.println(solutionWithStream1(new String[0]));
        System.out.println(solutionWithStream1(null));
    }

    static Map<String, Integer> solutionWithMap(String[] strings) {
        if (strings == null) throw new IllegalArgumentException("Input should not be null");
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map;
    }

    static Map<String, Long> solutionWithStream1(String[] strings) {
        if (strings == null) throw new IllegalArgumentException("Input should not be null");
        return Arrays.stream(strings)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // other solutions:

    // to be able to return Map<String, Integer>
    static Map<String, Integer> solutionWithStream2(String[] strings) {
        if (strings == null) throw new IllegalArgumentException("Input should not be null");
        return Arrays.stream(strings)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(s -> s, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    static Map<String, Integer> solutionWithStream3(String[] strings) {
        if (strings == null) throw new IllegalArgumentException("Input should not be null");
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(strings) // Streaming over strings
                .filter(Objects::nonNull)
                .distinct() // Stream is working on the distinct elements of the strings
                .forEach( // performs the below code for each element of the strings
                        e -> map.put(e, (int) Arrays.stream(strings).filter(p -> p != null && p.equals(e)).count()));    // put method adds all unique elements of the strings one by one with their occurrence counts.
        return map;
    }
}
