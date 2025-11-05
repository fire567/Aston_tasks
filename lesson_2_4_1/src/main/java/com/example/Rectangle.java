package com.example;

public class Rectangle implements Figure {
    private String fillColor;
    private String borderColor;
    private int height;
    private int width;

    public Rectangle(int height, int width, String fillColor, String borderColor) {
        this.height = height;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double square() {
        int result = height * width;
        return result;
    }

    @Override
    public double perimeter() {
        double result = 2 * height + 2 * width;
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
