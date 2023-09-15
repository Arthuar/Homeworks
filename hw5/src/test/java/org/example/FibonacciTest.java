package org.example;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
    @BeforeClass
    public static void beforeClassStartTestTime() {
        System.out.println("Test class has been started at: " + System.currentTimeMillis());
    }

    @AfterClass
    public static void afterClassStartTestTime() {
        System.out.println("Test class has been finished at: " + System.currentTimeMillis());
    }

    @Before
    public void beforeStartTestTime() {
        System.out.println("Test has been started at: " + System.currentTimeMillis());
    }

    @After
    public void afterStartTestTime() {
        System.out.println("Test has been finished at: " + System.currentTimeMillis());
    }

    @Test
    public void fibonacciDpTest() {
        //Given
        FibonacciDp fd = new FibonacciDp();

        //When
        int number = 5;
        final long result = fd.fibonacci(number);

        //Then
        int expected = 5;
        assertEquals(expected, result);
    }

    @Test
    public void fibonacciItTest() {
        //Given
        FibonacciIteration fi = new FibonacciIteration();

        //When
        int number = 6;
        final long result = fi.sum(number);

        //Then
        int expected = 8;
        assertEquals(expected, result);
    }

    @Test
    public void fibonacciRecTest() {
        //Given
        FibonacciRecursion fr = new FibonacciRecursion();

        //When
        int number = 7;
        final long result = fr.fibonacciRecursion(number);

        //Then
        int expected = 13;
        assertEquals(expected, result);
    }
}
