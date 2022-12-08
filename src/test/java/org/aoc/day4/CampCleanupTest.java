package org.aoc.day4;

import org.aoc.AOC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CampCleanupTest {
    List<String> input;
    CampCleanup cc;

    @BeforeEach
    void setUp() {
        input = AOC.getInput("src/test/resources/day4.txt");
        cc = new CampCleanup();
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        List<String> input = List.of("2-4,6-8", "2-3,4-5");
        Stream<List<Integer>> expectedInput = Stream.of(List.of(2, 4, 6, 8), List.of(2, 3, 4, 5));

        // Act
        Stream<List<Integer>> processedInput = CampCleanup.processInput(input);

        // Assert
        assertEquals(expectedInput.toList(), processedInput.toList());
    }

    @Test
    void shouldCalculatePartOne() {
        // Arrange
        Long expected = 2L;

        // Act
        Long actual = cc.partOne(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculatePartTwo() {
        // Arrange
        Long expected = 4L;

        // Act
        Long actual = cc.partTwo(input);

        // Assert
        assertEquals(expected, actual);
    }
}
