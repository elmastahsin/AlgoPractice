package algo.week03;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindFactorial {
    /*
    Write a method that returns the factorial number of any given number.
    Factorial: Factorial of a non-negative integer, is multiplication of all positive integers smaller than or equal to n.
    For example, factorial of 6 is 6*5*4*3*2*1 which is 720.
     */

    public static void main(String[] args) {
        System.out.println(solutionWithStream2(5));
        System.out.println(solutionWithStream2(1));
        System.out.println(solutionWithStream2(0));
        System.out.println(solutionWithStream2(-2));
    }

    public static int solutionWithFor(int n) {
        if (n < 0) throw new IllegalArgumentException("input should be positive number or zero");
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static int solutionWithStream(int n) {
        if (n < 0) throw new IllegalArgumentException("input should be positive number or zero");
        return Stream.iterate(1, i -> i < n, i -> i + 1)        // with java 9
                .reduce(1, (x, y) -> x * y);
    }

    public static int solutionWithStream2(int n) {
        if (n < 0) throw new IllegalArgumentException("input should be positive number or zero");
        return Stream.iterate(1, i -> i + 1)
                .limit(n)
                .reduce(1, (x, y) -> x * y);
    }

    public static int solutionWithStream3(int n) {
        if (n < 0) throw new IllegalArgumentException("input should be positive number or zero");
        return IntStream.range(1, n + 1)//returns IntStream
                .reduce(1, (x, y) -> x * y); //Performs a reduction on the elements
        // of this stream, using an associative accumulation function
    }

}
