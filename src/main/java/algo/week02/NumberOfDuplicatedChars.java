package algo.week02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOfDuplicatedChars {

    public static int getNumber5(String str) {
        String[] ch = str.toLowerCase().split("");
//        char[] ch1 = str.toLowerCase().toCharArray();
        String newString = "";
        for (String each : ch) {    //compare each
            int counter = 0;
            for (String result : ch) {
                if (result.equals(each)) {
                    counter++;
                }
            }
            if (counter > 1 && !(newString.contains(each))) {
                newString += each;
            }
        }
        return newString.length();
    }

    public static int getNumber2(String str) {
        String[] ch = str.toLowerCase().split("");
        HashSet<String> duplicatedChars = new HashSet<>();
        for (String each : ch) {    //compare each
            int counter = 0;
            for (String result : ch) {
                if (result.equals(each)) {
                    counter++;
                }
            }
            if (counter > 1) {
                duplicatedChars.add(each);
            }
        }
        return duplicatedChars.size();
    }

    public static int getNumber3(String str) {
        str = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
//            if (!map.containsKey(ch)) {
//                map.put(ch, 1);
//            } else {
//                map.put(ch, map.get(ch) + 1);
//            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        map.entrySet().removeIf(e -> e.getValue() == 1);
        return map.size();
    }

//    public static int getNumber4(String str) {
//        str = str.toLowerCase();
//        String temp = "";
//        String output = "";
//        for (Character ch : str.toCharArray()) {
//            if (!temp.contains(ch + "")) {
//                temp += ch;
//            } else if (!output.contains(ch + "")) {
//                output += ch;
//            }
//        }
//        return output.length();
//    }

    public static int getNumber(String str) {

        return (int) str.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .values().stream()
                .filter(l -> l > 1)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(getNumber("abcde") == 0);
        System.out.println(getNumber("aabbcde") == 2);
        System.out.println(getNumber("aabBcde") == 2);
        System.out.println(getNumber("indivisibility") == 1);
        System.out.println(getNumber("Indivisibilities") == 2);
        System.out.println(getNumber("aA11") == 2);
        System.out.println(getNumber("ABBA") == 2);
    }

}