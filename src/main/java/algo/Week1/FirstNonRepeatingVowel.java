package algo.Week1;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingVowel {


    public static void main(String[] args) {
        int index = getIndexOfFirstNonRepeatingVowel_nestedLoop("google");
        System.out.println(index);
        System.out.println(getIndexOfFirstNonRepeatingVowel_nestedLoop("bbddeeaffgi"));
        System.out.println(getIndexOfFirstNonRepeatingVowel_nestedLoop("aaabbbeeeoouu"));

        System.out.println(getIndexOfFirstNonRepeatingVowel_map("google"));
        System.out.println(getIndexOfFirstNonRepeatingVowel_map("bbddeeaffgi"));
        System.out.println(getIndexOfFirstNonRepeatingVowel_map("aaabbbeeeoouu"));
    }

    static int getIndexOfFirstNonRepeatingVowel_map(String input) {
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

    public static int getIndexOfFirstNonRepeatingVowel_nestedLoop(String input) {
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

