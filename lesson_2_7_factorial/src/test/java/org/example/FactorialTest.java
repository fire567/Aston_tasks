package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @DisplayName("Тестирование функции факториала")
    @Test
    void testFactorial() throws MyNegativeValueExсeption {
        assertEquals(120, Factorial.calculateFactorial(5));
    }

    @DisplayName("Тестирование функции факториала со значением 0")
    @Test
    void testFactorialWithZero() throws MyNegativeValueExсeption {
        assertEquals(0, Factorial.calculateFactorial(0));
    }

    @DisplayName("Тестирование функции факториала со значением меньше 0")
    @Test
    void testFactorialWithNegativevalue() {
        Exception exception = assertThrows(MyNegativeValueExсeption.class, () -> Factorial.calculateFactorial(-1));
        assertEquals("Значение меньше 0", exception.getMessage());
    }
}