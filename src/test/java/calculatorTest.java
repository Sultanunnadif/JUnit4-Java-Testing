import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculatorTest {
    @Test
    public void testAddition() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testAdditionWithNegativeNumbers() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(-2, -3);

        // Assert
        assertEquals(-5, result);
    }

    @Test
    public void testAdditionWithZero() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(0, 5);

        // Assert
        assertEquals(5, result);
    }
}
