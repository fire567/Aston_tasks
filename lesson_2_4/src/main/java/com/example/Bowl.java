package com.example;

public class Bowl {
    private int fulness;

    public Bowl(int fulness) {
        this.fulness = fulness;
    }

    public int getFulness() {
        return fulness;
    }

    public void decreaseAmountOfFood(int eatenFood) {
        fulness -= eatenFood;
    }

    public int amountOfFood() {
        return fulness;
    } 

    public void addFood(int value) {
        fulness += value;
    }
}
