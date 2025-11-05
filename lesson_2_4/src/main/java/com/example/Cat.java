package com.example;

public class Cat extends Animal {
    private static int count = 0; 
    private boolean satiety = false;
    private int foodNeeded;

    public Cat(int foodNeeded) {
        super.incrementAllAnimalsCount();
        count++;
        this.foodNeeded = foodNeeded;
    }

    @Override
    public void run(int distance) {
        if(distance <= 200 && distance >= 0) {
            System.out.println("Кот пробежал " + distance + " м");
        } else if (distance > 200 || distance < 0) {
            System.out.println("Кот может бежать до 200 метров и значение должно быть больше 0");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не может плавать ");
    }

    public static void showAnimalsCount() {
       System.out.println("Кол-во котов: " + count);
    }

    public void setSatiety(boolean newSatiety) {
        satiety = newSatiety;
    }

    public static void eatFood(Cat[] cats, Bowl bowl) {
        for(int i = 0; i < cats.length; i++) {
            if(bowl.getFulness() - cats[i].foodNeeded >= 0) {
                cats[i].setSatiety(true);
                bowl.decreaseAmountOfFood(cats[i].foodNeeded);
            }
            System.out.println("Сытость кошки " + i + ": " + cats[i].satiety);
            System.out.println("Оставшаяся еда: " + bowl.amountOfFood());
        }
    }
    
}
