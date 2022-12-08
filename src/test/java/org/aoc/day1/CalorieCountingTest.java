package org.aoc.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalorieCountingTest {
    List<Integer> elf1 = List.of(1000, 2000, 3000);
    List<Integer> elf2 = List.of(4000);
    List<Integer> elf3 = List.of(5000, 6000);
    List<Integer> elf4 = List.of(7000, 8000, 9000);
    List<Integer> elf5 = List.of(10000);
    List<List<Integer>> input;

    @BeforeEach
    void setUp() {
        input = List.of(elf1, elf2, elf3, elf4, elf5);
    }

    @Test
    void shouldProcessInput() throws IOException {
        // Act
        List<List<Integer>> processedInput = CalorieCounting.processInput("src/test/resources/day1.txt");

        // Assert
        assertEquals(input, processedInput);
    }

    @Test
    void shouldCountMaxCalories() {
        // Arrange
        int expectedMaxCalories = 24000;

        // Act
        List<Integer> calories = CalorieCounting.countCalories(input);

        // Assert
        int actualMaxCalories = Collections.max(calories);
        assertEquals(expectedMaxCalories, actualMaxCalories);
    }

    @Test
    void shouldCountTopThreeMaxCalories() {
        // Arrange
        int expectedCalories = 45000;

        // Act
        List<Integer> calories = CalorieCounting.countCalories(input);

        // Assert
        Collections.sort(calories);
        Integer max1 = calories.get(calories.size() - 1);
        Integer max2 = calories.get(calories.size() - 2);
        Integer max3 = calories.get(calories.size() - 3);
        int actualCalories = max1 + max2 + max3;
        assertEquals(expectedCalories, actualCalories);
    }
}
