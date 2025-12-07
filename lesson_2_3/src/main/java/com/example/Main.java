package com.example;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Iphone 10", "05.02.2025", "Apple", "USA", 5599, false);
        productsArray[2] = new Product("Iphone 11", "10.03.2025", "Apple", "USA", 5599, true);
        productsArray[3] = new Product("HUAWEI nova 14 Pro", "01.02.2024", "Huawei", "Korea", 5599, true);
        productsArray[4] = new Product("Galaxy S25 FE", "11.10.2026", "Samsung Corp.", "Korea", 5599, false);

        productsArray[0].showProductInfo();


        Park.Attraction attraction = new Park().new Attraction("\n" +
                "ferris wheel", "12:00", "19:00", 500);

        attraction.getName();
    }
}