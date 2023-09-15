package org.example;

public class Calc {
    public int sum(int val1, int val2){
        return val1 + val2;
    }
    public int subtraction(int val1, int val2){
        return val1 - val2;
    }

    public int multiplication(int val1, int val2){
        if(val2 == 0 || val1 == 0){
            throw new IllegalArgumentException();
        }
        return val1 * val2;
    }

    public double division(int val1, int val2){
        if(val1 == 0 || val2 == 0){
            throw new IllegalArgumentException();
        }
        return (double) (val1 / val2);
    }
}
