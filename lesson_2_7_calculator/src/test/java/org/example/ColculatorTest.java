package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColculatorTest {

    @DisplayName("Тестирование функции суммы")
    @ParameterizedTest
    @CsvSource({
            "0, 0, 0",
            "10, 11, 21",
            "10, -20, -10"
    })
    void testSum(int a, int b, int result) {
        assertEquals(result, Colculator.sum(a, b));
    }

    @DisplayName("Тестирование функции вычитания")
    @ParameterizedTest
    @CsvSource({
            "0, 0, 0",
            "10, -9, 19",
            "10, 20, -10"
    })
    void testDecrement(int a, int b, int result) {
        assertEquals(result, Colculator.decrement(a, b));
    }

    @DisplayName("Тестирование функции деления")
    @ParameterizedTest
    @CsvSource({
            "0, 10, 0",
            "10, -2, -5",
            "10, 20, 0.5"
    })
    void testDivide(double a, double b, double result) {
        assertEquals(result, Colculator.divide(a, b));
    }

    @DisplayName("Деление на 0")
    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> Colculator.divide(1, 0));
        assertEquals("Divide by zero", exception.getMessage());
    }

    @DisplayName("Тестирование функции умножения")
    @ParameterizedTest
    @CsvSource({
            "0, 10, 0",
            "10, -2, -20",
            "10, 20, 200"
    })
    void testMultiply(int a, int b, int result) {
        assertEquals(result, Colculator.multiply(a, b));
    }

}