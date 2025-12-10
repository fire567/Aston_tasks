package org.example;

import java.util.HashMap;

public class BasePage {

    public boolean placeholdersComparsion(PlaceholdersData expectedPlaceholders, HashMap<String, String> actualPlaceholders) {
        for (String placeholder : actualPlaceholders.keySet()) {
            String expectedPlaceholder = expectedPlaceholders.getPlaceholdersData().get(placeholder);
            String actualPlaceholder = actualPlaceholders.get(placeholder);
            if(!expectedPlaceholder.equals(actualPlaceholder)) {
                return false;
            }
        }
        return true;
    }

    public boolean placeholdersComparsion(PaymentsPlaceholdersData expectedPlaceholders, HashMap<String, String> actualPlaceholders) {
        for (String placeholder : actualPlaceholders.keySet()) {
            String expectedPlaceholder = expectedPlaceholders.getPlaceholdersData().get(placeholder);
            String actualPlaceholder = actualPlaceholders.get(placeholder);
            if(!expectedPlaceholder.equals(actualPlaceholder)) {
                return false;
            }
        }
        return true;
    }
}
