package org.example;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTest {

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
    public void testSum(){
        //Given

        Calc calc = new Calc();

        //When

        final int val1 = 1;
        final int val2 = 2;

        final int result = calc.sum(val1, val2);

        //Then

        final int expected = (val1 + val2);
        assertEquals(expected, result);

    }

    @Test
    public void testSubtraction(){
        //Given

        Calc calc = new Calc();

        //When

        final int val1 = 2;
        final int val2 = 2;

        final  int result = calc.subtraction(val1, val2);

        //Then

        final int expected = (val1 - val2);
        assertEquals(expected, result);

    }

    @Test
    public void testMultiplication(){
        //Given

        Calc calc = new Calc();

        //When

        final int val1 = 2;
        final int val2 = 2;

        final  int result = calc.multiplication(val1, val2);

        //Then

        final int exepected = val1 * val2;
        assertEquals(exepected, result);
    }

    @Test
    public void testDivision(){
        //Given
        Calc calc = new Calc();

        //When

        final int val1 = 2;
        final int val2 = 2;
        final double result = calc.division(val1, val2);

        //Then

        final double expected = val1 / val2;
        assertEquals(expected, result);
    }

    @Test
    public void testMultiplicationByZero(){
        //Given
        Calc calc = new Calc();

        //When & Then

        final int val1 = 2;
        final int val2 = 0;

        assertThrows(IllegalArgumentException.class, () -> calc.multiplication(val1, val2));
    }

    @Test
    public void testDivisionByZero(){
        //Given

        Calc calc = new Calc();

        //When & Then

        final int val1 = 2;
        final int val2 = 0;

        assertThrows(IllegalArgumentException.class, () -> calc.division(val1, val2));
    }
}
