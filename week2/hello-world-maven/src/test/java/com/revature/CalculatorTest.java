package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void add2and2() {
        // AAA
        // Arrange
        Calculator c = new Calculator();

        // Act
        double actual = c.add(2, 2);

        // Assert
        double expected = 4.0;
        Assertions.assertEquals(expected, actual);
    }

}
