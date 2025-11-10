package org.example;

public class Colculator {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int decrement(int a, int b) {
        return a - b;
    }

    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero");
        }

        return a / b;
    }

    public static double multiply(int a, int b) {
        return a * b;
    }
}
