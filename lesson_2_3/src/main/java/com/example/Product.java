package com.example;

public class Product {
    String name;
    String date;
    String manufacturer;
    String country;
    int price;
    boolean isReserved;

    public Product(String name, String date, String manufacturer, String country, int price, boolean isReserved) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void showProductInfo() {
        System.out.println(name);
        System.out.println(date);
        System.out.println(manufacturer);
        System.out.println(country);
        System.out.println(price);
        System.out.println(isReserved);
    }

}
