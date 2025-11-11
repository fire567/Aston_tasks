package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparsionTest {
    @Test(testName = "Проверка одинаквых значений")
    void testMakeComparsion() {
        boolean result = Comparsion.makeComparsion(3, 3);
        Assert.assertTrue(result);
    }

    @Test(testName = "Проверка разных значений")
    void testMakeComparsionNotEqualValues() {
        boolean result = Comparsion.makeComparsion(3, 4);
        Assert.assertFalse(result);
    }
}
