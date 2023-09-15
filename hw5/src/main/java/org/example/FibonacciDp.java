package org.example;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDp {
    //    Часова складність O(n)  - 5
//    Просторова складність O(n) - 5

    private static Map<Integer, Long> memo = new HashMap<>();

    public long fibonacci(int number) {
        if (number <= 1) {
            return number;
        }

        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        long fib = FibonacciIteration.sum(number);
        memo.put(number, fib);
        return fib;
    }
}