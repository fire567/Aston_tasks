package com.example;

public class Triangle implements Figure {
    private String fillColor;
    private String borderColor;
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double square() {
        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }

    @Override
    public void showInfo() {
        System.out.println(" [ " + "Периметр: " + perimeter(new int[] {a, b, c}) + ", "
         + "Площадь: " + square() + ", " 
         + "Цвет фона: " + fillColor + ", " 
         + "Цвет границ: " + borderColor);
    }
    
}
