package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

class FactorialTest {
    @Test(testName = "Тестирование функции факториала")
    void testFactorial() throws MyNegativeValueExсeption {
        Assert.assertEquals(Factorial.calculateFactorial(5), 120);
    }

    @Test(testName = "Тестирование функции факториала со значением 0")
    void testFactorialWithZero() throws MyNegativeValueExсeption {
        Assert.assertEquals(Factorial.calculateFactorial(0), 0);
    }

    @Test(testName = "Тестирование функции факториала со значением меньше 0")
    void testFactorialWithNegativevalue() {
        Exception exception = Assert.expectThrows(MyNegativeValueExсeption.class, () -> Factorial.calculateFactorial(-1));
        Assert.assertEquals(exception.getMessage(), "Значение меньше 0");
    }
}