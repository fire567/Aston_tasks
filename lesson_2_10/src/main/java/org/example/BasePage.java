package org.example;

import java.util.HashMap;

public class BasePage {
    public boolean placeholdersComparsion(PlaceholdersData expectedPlaceholders, HashMap<String, String> actualPlaceholders) {
        for (String placeholder : actualPlaceholders.keySet()) {
            String expectedPlaceholder = expectedPlaceholders.getPlaceholdersData().get(placeholder);
            String actualPlaceholder = actualPlaceholders.get(placeholder);
            System.out.println("[ " + placeholder + ": " + actualPlaceholder + " ] = " + "[ " + placeholder + ": " + expectedPlaceholder + " ]");
            if(!expectedPlaceholder.equals(actualPlaceholder)) {
                System.out.println("[ " + placeholder + ": " + actualPlaceholder + " ] != " + "[ " + placeholder + ": " + expectedPlaceholder + " ]");
                return false;
            }
        }
        return true;
    }

    public boolean placeholdersComparsion(PaymentsPlaceholdersData expectedPlaceholders, HashMap<String, String> actualPlaceholders) {
        for (String placeholder : actualPlaceholders.keySet()) {
            String expectedPlaceholder = expectedPlaceholders.getPlaceholdersData().get(placeholder);
            String actualPlaceholder = actualPlaceholders.get(placeholder);
            System.out.println("[ " + placeholder + ": " + actualPlaceholder + " ] = " + "[ " + placeholder + ": " + expectedPlaceholder + " ]");
            if(!expectedPlaceholder.equals(actualPlaceholder)) {
                System.out.println("[ " + placeholder + ": " + actualPlaceholder + " ] != " + "[ " + placeholder + ": " + expectedPlaceholder + " ]");
                return false;
            }
        }
        return true;
    }
}
