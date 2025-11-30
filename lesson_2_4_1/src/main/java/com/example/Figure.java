package com.example;

public interface Figure {
    void showInfo();
    double square();

    default double perimeter(int[] sidesArray) {
        int result = 0;
        for (int i = 0; i < sidesArray.length; i++) {
          result += sidesArray[i];
        };

        if (sidesArray.length == 2) return result * 2;
        return result;
    };
}