package algo.week03;

import java.util.Arrays;
import java.util.Optional;

public class ArrayOfDigits {
    /*
    How to convert a positive int to an array of digits.
    Input: 490		Output: [4, 9, 0] (as int Array)
     */


    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(getDigits(String.valueOf(490))));
            System.out.println(Arrays.toString(getDigits(String.valueOf(0))));
            System.out.println(Arrays.toString(getDigits(String.valueOf(-5))));
            System.out.println(Arrays.toString(getDigits(null)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static int[] getDigits(String str) {
        var number = Optional.ofNullable(Integer.parseInt(str)).orElseThrow(() -> new IllegalArgumentException("message")); // Just check
        if (number < 0)
            throw new IllegalArgumentException("input should not be null or negative integer");
        char[] chars = Integer.toString(number).toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) { // -   5
            ints[i] = chars[i] - '0';
        }
        return ints;
    }

    static int[] getDigitsWithStream(int number) {
        return Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)    //  .map(c -> Character.getNumericValue(c)) //same
                .toArray();
    }

    static int[] getDigitsWithStream2(int number) {
        return Integer.toString(number)
                .chars()
                .map(c -> c - '0')
                .toArray();
    }


}

