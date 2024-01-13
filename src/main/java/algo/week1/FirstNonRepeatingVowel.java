package algo.week1;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingVowel {


    public static void main(String[] args) {
        int index = getIndexOfFirstNonRepeatingVowelNestedLoop("google");
        System.out.println(index);
        System.out.println(getIndexOfFirstNonRepeatingVowelNestedLoop("bbddeeaffgi"));
        System.out.println(getIndexOfFirstNonRepeatingVowelNestedLoop("aaabbbeeeoouu"));

        System.out.println(getIndexOfFirstNonRepeatingVowelMap("google"));
        System.out.println(getIndexOfFirstNonRepeatingVowelMap("bbddeeaffgi"));
        System.out.println(getIndexOfFirstNonRepeatingVowelMap("aaabbbeeeoouu"));
    }

    static int getIndexOfFirstNonRepeatingVowelMap(String input) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (!map.containsKey(ch)) {
                    map.put(ch, i);
                } else {
                    map.put(ch, -5);
                }
            }
        }
        if (!map.isEmpty()) {
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                int index = e.getValue();
                if (index != -5) {
                    return index;
                }
            }
        }
        return -1;
    }

    public static int getIndexOfFirstNonRepeatingVowelNestedLoop(String input) {
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                int vowelCount = 0;
                for (int j = 0; j < length; j++) {
                    if (ch == input.charAt(j)) {
                        vowelCount++;
                    }
                }
                if (vowelCount == 1)
                    return i;
            }
        }
        return -1;
    }
}

