package com.suncorp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(Factorial.computeFactorial(0), 1);
    }

    @Test
    public void testFactorialOne() {
        Assert.assertEquals(Factorial.computeFactorial(1), 1);
    }

    @Test
    public void testFactorialFive() {
        Assert.assertEquals(Factorial.computeFactorial(5), 120);
    }

    @Test
    public void testFactorialTen() {
        Assert.assertEquals(Factorial.computeFactorial(10), 3628800);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial.computeFactorial(-1);
    }
}
