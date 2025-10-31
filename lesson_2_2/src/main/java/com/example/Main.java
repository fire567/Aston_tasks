package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumValueBetween(10, 11));
        checkPositiveOrNegativeValue(100);
        checkPositiveOrNegativeValue_2(5);
        printString("лол", 3);
        System.out.println(yearCheck(800));
        System.out.println(revertNumbers());
        System.out.println(fillArray());
        System.out.println(multiplyArrayValue());
        System.out.println(fillMatrix());
        System.out.println(fillArray(5, 6));
    }

    //1
    public static void printThreeWords() {
        System.out.println("Orange " + "\n" + "Banana" + "\n" + "Apple");
    }

    //2
    public static void checkSumSign() {
        int a = 2, b = 0;

        if(a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3
    public static void printColor() {
        int value = 101;

        if(value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4
    public static void compareNumbers() {
       int a = 4, b = 5;

       if(a >= b){
        System.out.println("a >= b");
       } else {
        System.out.println("a < b");
       }
    }

    //5
    public static boolean checkSumValueBetween(int a, int b) {
        if (a + b >= 10 && a + b <= 20){
            return true;
        } else return false;
    }

    //6
    public static void checkPositiveOrNegativeValue (int value) {
        if (value >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    //7
    public static boolean checkPositiveOrNegativeValue_2(int value) {
        if (value >= 0){
            return false;
        } else return true;
    }

    //8
    public static void printString(String string, int times) {
        for(int i = 0; i < times; i++){
            System.out.println(string);
        }
    }

    //9
    public static boolean yearCheck(int year) {
        if(year % 400 == 0){
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } return false;
    }

    //10
    public static String revertNumbers() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                result[i] = 1;
            } else if(array[i] == 1) {
                result[i] = 0;
            }
        } 

        return Arrays.toString(result);
    }

    //11
    public static String fillArray() {
        int[] result = new int[100];

        for (int i = 0; i < result.length; i++) {
            result[i] = i+1;
        } 

        return Arrays.toString(result);
    }

    //12
    public static String multiplyArrayValue() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] result = new int[array.length];

        for (int i = 0; i < result.length; i++) {
            if(array[i] < 6){
                result[i] = array[i] * 2;
            }else result[i] = array[i];
        } 

        return Arrays.toString(result);
    }

    //13
    public static String fillMatrix() {
        int[] first_array = new int[5];

        int[][] result = new int[first_array.length][first_array.length];

        for(int i = 0; i < first_array.length; i++) {
            for(int j = 0; j < first_array.length; j++){
                if(i == j) {
                    result[i][j] = 1;
                } else result[i][j] = 0;
                result[first_array.length - 1 - j][j] = 1;
            }
        }
        
        return Arrays.deepToString(result);
    }

    //14
    public static String fillArray(int len, int initialValue) {
        int[] result = new int[len];

        for (int i = 0; i < result.length; i++) {
            result[i] = initialValue;
        } 

        return Arrays.toString(result);
    }
}