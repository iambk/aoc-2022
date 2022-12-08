package org.aoc.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalorieCountingTest {
    CalorieCounting cc;
    List<List<Integer>> input;

    @BeforeEach
    void setUp() {
        cc = new CalorieCounting();
        input = List.of(
                List.of(1000, 2000, 3000),
                List.of(4000),
                List.of(5000, 6000),
                List.of(7000, 8000, 9000),
                List.of(10000));
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        Stream<String> input = Stream.of("1000", "2000", "3000", "", "4000");
        List<Integer> elf1 = List.of(1000, 2000, 3000);
        List<Integer> elf2 = List.of(4000);
        List<List<Integer>> expectedInput = List.of(elf1, elf2);

        // Act
        List<List<Integer>> processedInput = cc.processInput(input);

        // Assert
        assertEquals(expectedInput, processedInput);
    }

    @Test
    void shouldCountMaxCalories() {
        // Arrange
        int expectedMaxCalories = 24000;

        // Act
        int actualMaxCalories = cc.partOne(input);

        // Assert
        assertEquals(expectedMaxCalories, actualMaxCalories);
    }

    @Test
    void shouldCountTopThreeMaxCalories() {
        // Arrange
        int expectedCalories = 45000;

        // Act
        int actualCalories = cc.partTwo(input);

        // Assert
        assertEquals(expectedCalories, actualCalories);
    }
}
