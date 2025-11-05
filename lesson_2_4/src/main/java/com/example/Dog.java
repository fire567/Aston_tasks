package com.example;

public class Dog extends Animal{
    private static int count = 0; 

    public Dog() {
        super.incrementAllAnimalsCount();
        count++;
    }

    @Override
    public void run(int distance) {
        if(distance <= 500 && distance >= 0) {
            System.out.println("Собака пробежала " + distance + " м");
        } else if (distance > 500 || distance < 0) {
            System.out.println("Собака может бежать до 500 метров и значение должно быть больше 0");
        }
    }

    @Override
    public void swim(int distance) {
        if(distance <= 10 && distance >= 0) {
            System.out.println("Собака проплыла " + distance + " м");
        } else if (distance > 10 || distance < 0) {
            System.out.println("Собака может плыть до 10 метров и значение должно быть больше 0");
        }
    }

    public static void showAnimalsCount() {
       System.out.println("Кол-во Собак: " + count);
    }
}
