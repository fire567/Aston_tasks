package org.example;

import java.util.HashMap;

public class PaymentsLogosData {
    private HashMap<String, String> expectedLogosData = new HashMap<>();
    public PaymentsLogosData() {
        expectedLogosData.put("visa", "visa-system");
        expectedLogosData.put("mastercard", "mastercard-system");
        expectedLogosData.put("belkart", "belkart-system");
        expectedLogosData.put("maestro", "maestro-system");
        expectedLogosData.put("mir", "mir-system-ru");
    }

    public HashMap<String, String> getLogosData() {
        return expectedLogosData;
    };
}
