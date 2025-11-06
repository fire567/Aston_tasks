package com.example;

public class Main {
    public static void main(String[] args) {
        String[][] matrix = {{"1", "2", "3", null}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
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

    public static int sumElements(String[][] matrix) {
        //Проверка размерности массива
        if (matrix.length != 4 || matrix[0].length != 4) {
            try {
                throw new MyArraySizeException("Нужная размерность массива 4x4");
            } catch(Exception e) {
                System.out.println(e);
                return 0;
            }
            
        }

        int result = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                //Проверка элемента на число
                if(matrix[i][j] == null || matrix[i][j].isEmpty()){
                    try {
                        throw new MyArrayDataException("Все элементы массива должны быть числами. Ошибка в ячейке: " + "[" + i + "] " + "[" + j + "]");
                    } catch(Exception e) {
                        System.out.println(e);
                        return 0;
                    }
                }

                
                if(!matrix[i][j].matches("-?\\d+(\\.\\d+)?")) {
                    try {
                        throw new MyArrayDataException("Все элементы массива должны быть числами. Ошибка в ячейке: " + "[" +i + "] " + "[" + j + "]");
                    } catch(Exception e) {
                        System.out.println(e);
                    }
                } else {
                    int convertedValue = Integer.parseInt(matrix[i][j]);
                    result += convertedValue;
                }
            }
        }

        return result;
    }
    
}