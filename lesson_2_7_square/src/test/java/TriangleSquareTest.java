import org.example.MyTriangleException;
import org.example.TriangleSquare;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleSquareTest {

    @DisplayName("Тестирвоание функции расчёта площади")
    @ParameterizedTest
    @CsvSource({
            "3, 3, 3, 3.897114317029974",
            "4, 3, 3, 4.47213595499958"
    })
    void testTriangleSquare(double a, double b, double c, double result) throws MyTriangleException {
        assertEquals(result, TriangleSquare.calculateSquare(a, b, c));
    }

    @DisplayName("Тестирвоание функции валидности треугольника")
    @Test
    void testTriangleSquareIsNotExist() {
        Exception exception = assertThrows(Exception.class, () -> {TriangleSquare.calculateSquare(4, 3, 9);});
        assertEquals("Треугольника не существует", exception.getMessage());
    }
}
