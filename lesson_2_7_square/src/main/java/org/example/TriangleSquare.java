package org.example;

public class TriangleSquare {

    private static  boolean isTriangleExist(double a, double b, double c) {

        if(a+b > c && a+c > b && b+c > a ) return true;

        return false;
    }

    public static double calculateSquare(double a, double b, double c) throws MyTriangleException {

        if(isTriangleExist(a, b, c) == false) {
            throw new MyTriangleException("Треугольника не существует");
        }

        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }
}
