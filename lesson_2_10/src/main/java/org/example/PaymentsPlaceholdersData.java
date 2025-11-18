package org.example;

import java.util.HashMap;

public class PaymentsPlaceholdersData {
    public HashMap<String, String> expectedPlaceholdersData = new HashMap<>();
    public PaymentsPlaceholdersData() {
        expectedPlaceholdersData.put("cardNumber", "Номер карты");
        expectedPlaceholdersData.put("validityPeriod", "Срок действия");
        expectedPlaceholdersData.put("cvc", "CVC");
        expectedPlaceholdersData.put("firstAndSecondNames", "Имя и фамилия на карте");
    }

    public HashMap<String, String> getPlaceholdersData() {
        return expectedPlaceholdersData;
    };
}
