package com.example;

public class Main {
    public static void main(String[] args) {
        Circle circle_1 = new Circle(14, "Зелёный", "черный");
        Rectangle rectangle_1 = new Rectangle(5, 7, "Белый", "Черный");
        Triangle triangle_1 = new Triangle(3, 3, 4, "Красный", "синий");

        circle_1.showInfo();
        rectangle_1.showInfo();
        triangle_1.showInfo();
    }
}