package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ColculatorTest {

    @DataProvider(name = "sumTestData")
    public Object[][] sumTestData() {
        return new Object[][] {
                { 0, 0, 0 },
                { 1, 2, 3 },
                { 4, -10, -6 }
        };
    }

    @DataProvider(name = "decrementTestData")
    public Object[][] decrementTestData() {
        return new Object[][] {
                { 0, 0, 0 },
                { 1, 10, -9 },
                { 10, 3, 7 }
        };
    }

    @DataProvider(name = "divideTestData")
    public Object[][] divideTestData() {
        return new Object[][] {
                {0, 10, 0},
                {10, -2, -5},
                {10, 20, 0.5}
        };
    }

    @DataProvider(name = "multiplyTestData")
    public Object[][] multiplyTestData() {
        return new Object[][] {
                {0, 10, 0},
                { 10, -2, -20 },
                {10, 20, 200}
        };
    }

    @Test(testName = "Тестирование функции суммы", dataProvider = "sumTestData")
    void testSum(int a, int b, int result) {
         Assert.assertEquals(Colculator.sum(a, b), result);
    }


    @Test(testName = "Тестирование функции вычитания", dataProvider = "decrementTestData")
    void testDecrement(int a, int b, int result) {
        Assert.assertEquals(Colculator.decrement(a, b), result);
    }

    @Test(testName = "Тестирование функции деления", dataProvider = "divideTestData")
    void testDivide(double a, double b, double result) {
        Assert.assertEquals(Colculator.divide(a, b), result);
    }

    @Test(testName = "Деление на 0")
    void testDivisionByZero() {
        Exception exception = Assert.expectThrows(ArithmeticException.class, () -> Colculator.divide(1, 0));
        Assert.assertEquals(exception.getMessage(), "Divide by zero");
    }

    @Test(testName = "Тестирование функции умножения", dataProvider = "multiplyTestData")
    void testMultiply(int a, int b, int result) {
        Assert.assertEquals(Colculator.multiply(a, b), result);
    }
}