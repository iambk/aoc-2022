package org.aoc.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalorieCountingTest {
    @Test
    void shouldCountMaxCalories() throws IOException {
        // Arrange
        int expectedMaxCalories = 24000;

        // Act
        List<Integer> calories = CalorieCounting.countMaxCalories("src/test/resources/day1sample.txt");

        // Assert
        int actualMaxCalories = calories.get(calories.size() - 1);
        assertEquals(expectedMaxCalories, actualMaxCalories);
    }
}