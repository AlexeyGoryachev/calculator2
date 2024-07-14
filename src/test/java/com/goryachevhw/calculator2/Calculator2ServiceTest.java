package com.goryachevhw.calculator2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Calculator2ServiceTest {
    private final Calculator2Service calculator2Service = new Calculator2Service();

    @ParameterizedTest
    @CsvSource({
            "2, 2, 4",
            "-2, 2, 0",
            "-2, -2, -4"
    })
    public void testPlus(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, calculator2Service.plus(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2, 0",
            "-2, 2, -4",
            "-2, -2, 0"
    })
    public void testMinus(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, calculator2Service.minus(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 9",
            "-3, 3, -9",
            "-3, -3, 9"
    })
    public void testMultiply(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, calculator2Service.multiply(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 1",
            "-3, 3, -1",
            "-3, -3, 1"
    })
    public void testDivide(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, calculator2Service.divide(num1, num2));
    }

    @Test
    public void testMultiplyWithZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.multiply(0, 3));
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.multiply(3, 0));
    }

    @Test
    public void testDivideWithZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.divide(0, 3));
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.divide(3, 0));
    }
}
