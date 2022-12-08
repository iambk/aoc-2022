package org.aoc.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CampCleanupTest {
    List<Integer> pair1 = List.of(2, 4, 6, 8);
    List<Integer> pair2 = List.of(2, 3, 4, 5);
    List<Integer> pair3 = List.of(5, 7, 7, 9);
    List<Integer> pair4 = List.of(2, 8, 3, 7);
    List<Integer> pair5 = List.of(6, 6, 4, 6);
    List<Integer> pair6 = List.of(2, 6, 4, 8);
    List<List<Integer>> input;

    @BeforeEach
    void setUp() {
        input = List.of(pair1, pair2, pair3, pair4, pair5, pair6);
    }

    @Test
    void shouldProcessInput() throws IOException {
        // Act
        List<List<Integer>> processedInput = CampCleanup.processInput("src/test/resources/day4.txt");

        // Assert
        assertEquals(input, processedInput);
    }

    @Test
    void shouldCalculatePartOne() throws IOException {
        // Arrange
        int expected = 2;

        // Act
        int actual = CampCleanup.partOne(CampCleanup.processInput("src/test/resources/day4.txt"));

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculatePartTwo() throws IOException {
        // Arrange
        int expected = 4;

        // Act
        int actual = CampCleanup.partTwo(CampCleanup.processInput("src/test/resources/day4.txt"));

        // Assert
        assertEquals(expected, actual);
    }
}
