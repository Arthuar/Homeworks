package org.example;

public class App {
    public static void main(String[] args) {
        FibonacciIteration fn = new FibonacciIteration();
        int res = fn.sum(6);
        System.out.println(res);
        FibonacciDp fnDp = new FibonacciDp();
        long resDp = fnDp.fibonacci(5);
        System.out.println(resDp);
        FibonacciRecursion fnRec = new FibonacciRecursion();
        long resRec = fnRec.fibonacciRecursion(7);
        System.out.println(resRec);
    }
}
