package org.example;

import java.util.HashMap;

public class PlaceholdersData {

    public HashMap<String, String> expectedPlaceholdersData = new HashMap<>();

    public PlaceholdersData() {
        expectedPlaceholdersData.put("email", "E-mail для отправки чека");
        expectedPlaceholdersData.put("amount", "Сумма");
        expectedPlaceholdersData.put("phoneNumber", "Номер телефона");
        expectedPlaceholdersData.put("subscriberNumber", "Номер абонента");
        expectedPlaceholdersData.put("accountScore", "Номер счета на 44");
        expectedPlaceholdersData.put("debtScore", "Номер счета на 2073");
    }

    public HashMap<String, String> getPlaceholdersData() {
        return expectedPlaceholdersData;
    };
}
