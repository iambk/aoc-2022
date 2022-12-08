package org.aoc.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CampCleanupTest {
    CampCleanup cc;
    List<List<Integer>> input;

    @BeforeEach
    void setUp() {
        cc = new CampCleanup();
        input = List.of(
                List.of(2, 4, 6, 8),
                List.of(2, 3, 4, 5),
                List.of(5, 7, 7, 9),
                List.of(2, 8, 3, 7),
                List.of(6, 6, 4, 6),
                List.of(2, 6, 4, 8)
        );
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        Stream<String> input = Stream.of("2-4,6-8", "2-3,4-5");
        List<List<Integer>> expectedInput = List.of(List.of(2, 4, 6, 8), List.of(2, 3, 4, 5));

        // Act
        List<List<Integer>> processedInput = cc.processInput(input);

        // Assert
        assertEquals(expectedInput, processedInput);
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
