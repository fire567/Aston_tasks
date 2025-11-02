package com.example;

public class Park {
        class Attraction {
        private String name;
        private String starTime; 
        private String endTime; 
        private int price;

        public Attraction(String name, String starTime, String endTime, int price) {
            this.name = name;
            this.starTime = starTime;
            this.endTime = endTime;
            this.price = price;
        }

        public void getName() {
            System.out.println(name);
        }
    }
}
