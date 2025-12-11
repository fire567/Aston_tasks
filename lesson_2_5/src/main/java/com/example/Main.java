package com.example;

public class Main {
    public static void main(String[] args) {
        String[][] matrix = {{"1", "2", "3", "asd"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        System.out.println(sumElements(matrix));

        int[] array = {1, 2, 3};
        indexIsOutOfBounds(array);
    }

    public static void indexIsOutOfBounds(int[] array) {
        try{
            int result = array[array.length];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    static int parseStringToInt(String value, int i, int j) throws MyArrayDataException {
        int result = 0;

        try {
            result = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            throw new MyArrayDataException("Все элементы массива должны быть числами. Ошибка в ячейке: " + "[" + i + "] " + "[" + j + "]");
        }

        return result;
    };

    public static int sumElements(String[][] matrix) {
        //Проверка размерности массива
        try {
            if (matrix.length != 4 || matrix[0].length != 4) {
                throw new MyArraySizeException("Нужная размерность массива 4x4");
            }
        } catch(MyArraySizeException e) {
            System.out.println(e);
            return 0;
        }

        int result = 0;
        int convertedValue;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                //Проверка элемента на число
                try {
                    convertedValue = parseStringToInt(matrix[i][j], i, j);
                } catch(MyArrayDataException e) {
                    System.out.println(e);
                    return 0;
                }

                result += convertedValue;
            }
        }

        return result;
    }
}