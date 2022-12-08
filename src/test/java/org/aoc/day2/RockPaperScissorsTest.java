package org.aoc.day2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {
    @Test
    void shouldCalculateStrategyScorePartOne() throws IOException {
        // Arrange
        int expectedScore = 15;

        // Act
        int actualScore = RockPaperScissors.evaluatePartOne("src/test/resources/day2.txt");

        // Assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldCalculateStrategyScorePartTwo() throws IOException {
        // Arrange
        int expectedScore = 12;

        // Act
        int actualScore = RockPaperScissors.evaluatePartTwo("src/test/resources/day2.txt");

        // Assert
        assertEquals(expectedScore, actualScore);
    }
}