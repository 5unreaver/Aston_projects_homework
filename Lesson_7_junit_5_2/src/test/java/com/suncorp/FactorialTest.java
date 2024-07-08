package com.suncorp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    public void testComputeFactorial() {
        assertEquals(1, Factorial.computeFactorial(0));
        assertEquals(1, Factorial.computeFactorial(1));
        assertEquals(2, Factorial.computeFactorial(2));
        assertEquals(6, Factorial.computeFactorial(3));
        assertEquals(24, Factorial.computeFactorial(4));
        assertEquals(120, Factorial.computeFactorial(5));
    }

    @Test
    public void testFactorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.computeFactorial(-1);
        });
        assertEquals("Число не должно быть отрицательным.", exception.getMessage());
    }
}
