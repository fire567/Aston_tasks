package org.example;

public class Factorial {

    public static int calculateFactorial(int number) throws MyNegativeValueExсeption {

        int result = 1;

        if (number < 0) {
            throw new MyNegativeValueExсeption("Значение меньше 0");
        }

        if (number == 0) return  0;

        for(int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}
