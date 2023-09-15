package org.example;

public class FibonacciRecursion {
    //    Часова складність O(2^n)  - 128
//    Просторова складність O(n) - 7
    public long fibonacciRecursion(int number) {
        if (number <= 1) {
            return number;
        }
        return fibonacciRecursion(number - 1) + fibonacciRecursion(number - 2);
    }
}
