package com.example;

public class Circle implements Figure {
    private String fillColor;
    private String borderColor;
    private int radius;

    public Circle(int radius, String fillColor, String borderColor){
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double square() {
        double result = Math.PI * Math.pow(radius, 2);
        return result;
    }

    @Override
    public double perimeter() {
        double result = 2 * Math.PI * radius;
        return result;
    }

    @Override
    public void showInfo() {
        System.out.println(" [ " + "Периметр: " + perimeter() + ", "
         + "Площадь: " + square() + ", " 
         + "Цвет фона: " + fillColor + ", " 
         + "Цвет границ: " + borderColor);
    }
    
}
