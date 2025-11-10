import org.example.Comparsion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComparsionTest {
    @DisplayName("Проверка одинаквых значений")
    @Test
    void testMakeComparsion() {
        boolean result = Comparsion.makeComparsion(3, 3);
        assertTrue(result);
    }

    @DisplayName("Проверка разных значений")
    @Test
    void testMakeComparsionNotEqualValues() {
        boolean result = Comparsion.makeComparsion(3, 4);
        assertFalse(result);
    }
}
