package com.suncorp;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        System.out.println("Факториалом числа " + number + " является " + computeFactorial(number));
    }

    public static long computeFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не должно быть отрицательным.");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
