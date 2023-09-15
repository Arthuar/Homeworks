package org.example;

public class FibonacciIteration {
    //    Часова складність O(n)  - 6
//    Просторова складність O(1) -1
    int buff;

    public static int sum(int number) {
        int first = 0;
        int second = 1;
        int buff = 0;

        for (int i = 0; i < number; i++) {
            buff = first + second;
            first = second;
            second = buff;
        }
        return first;
    }
}
