package org.aoc.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RopeBridgeTest {
    RopeBridge rb;
    List<List<String>> input1;
    List<List<String>> input2;

    @BeforeEach
    void setUp() {
        rb = new RopeBridge();
        input1 = List.of(List.of("R", "4"),
                List.of("U", "4"),
                List.of("L", "3"),
                List.of("D", "1"),
                List.of("R", "4"),
                List.of("D", "1"),
                List.of("L", "5"),
                List.of("R", "2"));
        input2 = List.of(List.of("R", "5"),
                List.of("U", "8"),
                List.of("L", "8"),
                List.of("D", "3"),
                List.of("R", "17"),
                List.of("D", "10"),
                List.of("L", "25"),
                List.of("U", "20"));
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        Stream<String> commands = Stream.of("U 1", "R 2");
        List<List<String>> expectedInput = List.of(List.of("U", "1"), List.of("R", "2"));

        // Act
        List<List<String>> processedInput = rb.processInput(commands);

        // Assert
        assertEquals(expectedInput, processedInput);
    }

    @Test
    void shouldEvaluatePartOne() {
        // Arrange
        Integer expected = 13;

        // Act
        Integer actual = rb.partOne(input1);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoForInputOne() {
        // Arrange
        Integer expected = 1;

        // Act
        Integer actual = rb.partTwo(input1);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoForInputTwo() {
        // Arrange
        Integer expected = 36;

        // Act
        Integer actual = rb.partTwo(input2);

        // Assert
        assertEquals(expected, actual);
    }
}
