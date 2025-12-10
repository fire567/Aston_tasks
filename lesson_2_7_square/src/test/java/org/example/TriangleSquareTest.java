package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleSquareTest {

    @DataProvider(name = "triangleSquareTestData")
    public static Object[][] triangleSquareTestData() {
        return new Object[][]{
                {3.0, 3.0, 3.0, 3.897114317029974},
                {4.0, 3.0, 3.0, 4.47213595499958}
        };
    }

    @Test(testName = "Тестирвоание функции расчёта площади", dataProvider = "triangleSquareTestData")
    void testTriangleSquare(double a, double b, double c, double result) throws MyTriangleException {
        Assert.assertEquals(result, TriangleSquare.calculateSquare(a, b, c));
    }

    @Test(testName = "Тестирвоание функции валидности треугольника")
    void testTriangleSquareIsNotExist() {
        Exception exception = Assert.expectThrows(Exception.class, () -> {TriangleSquare.calculateSquare(4, 3, 9);});
        Assert.assertEquals(exception.getMessage(), "Треугольника не существует");
    }
}
