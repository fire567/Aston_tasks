package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> telephoneBook = new HashMap<>();

        telephoneBook.put("+744334534510", "Petrov");
        telephoneBook.put("+744334534511", "Petrov");
        telephoneBook.put("+744334534518", "Evseenko");
        telephoneBook.put("+744334614513", "Novikov");

        add(telephoneBook, "+744334534522", "Evseenko");
        get(telephoneBook, "Petrov");
        get(telephoneBook, "Evseenko");
    }

    public static void add(HashMap<String, String> telephoneBook, String number, String secondName) {
        telephoneBook.put(number, secondName);
    }

    public static void get(HashMap<String, String> telephoneBook, String secondName) {
        ArrayList<String> phones = new ArrayList<>();

        for(Map.Entry<String, String> element : telephoneBook.entrySet()) {
            if(element.getValue().equals(secondName)) {
                phones.add(element.getKey());
            }
        }

        System.out.println(phones);
    }
}