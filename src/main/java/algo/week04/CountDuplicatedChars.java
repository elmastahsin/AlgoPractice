package algo.week04;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicatedChars {
    /*
Problem : Count the number of Duplicated Letters
Write a function that will return the count of distinct case-insensitive alphabetic characters and
numeric digits that occur more than once in the input string.
The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Example:
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */

    public static void main(String[] args) {
        System.out.println(getNumber("abcde") == 0);
        System.out.println(getNumber("aabbcde") == 2);
        System.out.println(getNumber("aabBcde") == 2);
        System.out.println(getNumber("indivisibility") == 1);
        System.out.println(getNumber("Indivisibilities") == 2);
        System.out.println(getNumber("aA11") == 2);
        System.out.println(getNumber("ABBA") == 2);
    }

    public static int getNumber(String str) {
        str = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        map.entrySet().removeIf(e -> e.getValue() == 1);
        return map.size();
    }
}
