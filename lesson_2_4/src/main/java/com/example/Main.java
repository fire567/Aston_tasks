package com.example;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog();
        Dog dogGraf = new Dog();
        Dog dogJuchka = new Dog();
        Cat catFelicia = new Cat(10);
        Cat catTishka = new Cat(15);

        dogBobik.run(150);
        catFelicia.run(201);
        dogGraf.swim(9);
        catTishka.swim(333);

        Cat.showAnimalsCount();
        Dog.showAnimalsCount();
        Animal.showAllAnimalsCount();

        Cat[] catsArray = {catFelicia, catTishka};
        Bowl bowl = new Bowl(30);
        Cat.eatFood(catsArray, bowl);
        bowl.addFood(15);
        System.out.println("Кол-во еды после добавления: " + bowl.amountOfFood());
    }
}