package org.aoc.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {
    RockPaperScissors rps;
    List<List<String>> input;

    @BeforeEach
    void setUp() {
        rps = new RockPaperScissors();
        input = List.of(
                List.of("A", "Y"),
                List.of("B", "X"),
                List.of("C", "Z"));
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        Stream<String> input = Stream.of("A Y", "B X", "C Z");
        List<String> round1 = List.of("A", "Y");
        List<String> round2 = List.of("B", "X");
        List<String> round3 = List.of("C", "Z");
        List<List<String>> expectedInput = List.of(round1, round2, round3);

        // Act
        List<List<String>> processedInput = rps.processInput(input);

        // Assert
        assertEquals(expectedInput, processedInput);
    }

    @Test
    void shouldCalculateStrategyScorePartOne() {
        // Arrange
        int expectedScore = 15;

        // Act
        int actualScore = rps.partOne(input);

        // Assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldCalculateStrategyScorePartTwo() {
        // Arrange
        int expectedScore = 12;

        // Act
        int actualScore = rps.partTwo(input);

        // Assert
        assertEquals(expectedScore, actualScore);
    }
}
