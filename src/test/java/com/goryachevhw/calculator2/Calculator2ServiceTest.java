package com.goryachevhw.calculator2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Calculator2ServiceTest {
    private final Calculator2Service calculator2Service = new Calculator2Service();

    @Test
    public void testPlus() {
        assertEquals(4, calculator2Service.plus(2, 2));
        assertEquals(0, calculator2Service.plus(-2, 2));
    }

    @Test
    public void testMinus() {
        assertEquals(0, calculator2Service.minus(2, 2));
        assertEquals(-4, calculator2Service.minus(-2, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(9, calculator2Service.multiply(3, 3));
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.multiply(0, 5));
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.multiply(5, 0));
    }

    @Test
    public void testDivide() {
        assertEquals(1, calculator2Service.divide(3, 3));
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.divide(5, 0));
        assertThrows(IllegalArgumentException.class, () -> calculator2Service.divide(0, 5));
    }
}
