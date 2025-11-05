package com.example;

public abstract class Animal {
    private static int animalsCount = 0;
    public abstract void run(int distance);
    public abstract void swim(int distance);

    public static void incrementAllAnimalsCount(){
        animalsCount++;
    };

    public static void showAllAnimalsCount(){
        System.out.println("Кол-во всех животных: " + animalsCount);
    };
}
