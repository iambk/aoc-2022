package org.aoc.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {
    List<String> round1 = List.of("A", "Y");
    List<String> round2 = List.of("B", "X");
    List<String> round3 = List.of("C", "Z");
    List<List<String>> input;

    @BeforeEach
    void setUp() {
        input = List.of(round1, round2, round3);
    }

    @Test
    void shouldProcessInput() throws IOException {
        // Act
        List<List<String>> processedInput = RockPaperScissors.processInput("src/test/resources/day2.txt");

        // Assert
        assertEquals(input, processedInput);
    }

    @Test
    void shouldCalculateStrategyScorePartOne() {
        // Arrange
        int expectedScore = 15;

        // Act
        int actualScore = RockPaperScissors.evaluatePartOne(input);

        // Assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldCalculateStrategyScorePartTwo() {
        // Arrange
        int expectedScore = 12;

        // Act
        int actualScore = RockPaperScissors.evaluatePartTwo(input);

        // Assert
        assertEquals(expectedScore, actualScore);
    }
}
