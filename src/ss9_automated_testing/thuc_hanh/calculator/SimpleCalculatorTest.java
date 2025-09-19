package ss9_automated_testing.thuc_hanh.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

    @Test
    @DisplayName("Testing add 0 + 0")
    public void testAdd0And0() {
        int result = SimpleCalculator.add(0, 0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Testing add 1 + 0")
    public void testAdd1And0() {
        int result = SimpleCalculator.add(1, 0);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Testing add 0 + 1")
    public void testAdd0And1() {
        int result = SimpleCalculator.add(0, 1);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Testing add 5 + 3")
    public void testAdd5And3() {
        int result = SimpleCalculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("Testing sub 0 - 0")
    public void testSub0And0() {
        int result = SimpleCalculator.sub(0, 0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Testing sub 1 - 0")
    public void testSub1And0() {
        int result = SimpleCalculator.sub(1, 0);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Testing sub 0 - 1")
    public void testSub0And1() {
        int result = SimpleCalculator.sub(0, 1);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Testing sub 5 - 3")
    public void testSub5And3() {
        int result = SimpleCalculator.sub(5, 3);
        assertEquals(2, result);
    }
}
