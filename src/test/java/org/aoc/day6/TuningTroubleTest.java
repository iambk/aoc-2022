package org.aoc.day6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TuningTroubleTest {
    String input1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
    String input2 = "bvwbjplbgvbhsrlpgdmjqwftvncz";
    String input3 = "nppdvjthqldpwncqszvftbrmjlhg";
    String input4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
    String input5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

    TuningTrouble tt;

    @BeforeEach
    void setUp() {
        tt = new TuningTrouble();
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        Stream<String> input = Stream.of("abc");
        String expectedInput = "abc";

        // Act
        String processedInput = tt.processInput(input);

        // Assert
        assertEquals(expectedInput, processedInput);
    }

    @Test
    void shouldEvaluatePartOneInputOne() {
        // Arrange
        Integer expected = 7;

        // Act
        Integer actual = tt.partOne(input1);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartOneInputTwo() {
        // Arrange
        Integer expected = 5;

        // Act
        Integer actual = tt.partOne(input2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartOneInputThree() {
        // Arrange
        Integer expected = 6;

        // Act
        Integer actual = tt.partOne(input3);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartOneInputFour() {
        // Arrange
        Integer expected = 10;

        // Act
        Integer actual = tt.partOne(input4);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartOneInputFive() {
        // Arrange
        Integer expected = 11;

        // Act
        Integer actual = tt.partOne(input5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoInputOne() {
        // Arrange
        Integer expected = 19;

        // Act
        Integer actual = tt.partTwo(input1);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoInputTwo() {
        // Arrange
        Integer expected = 23;

        // Act
        Integer actual = tt.partTwo(input2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoInputThree() {
        // Arrange
        Integer expected = 23;

        // Act
        Integer actual = tt.partTwo(input3);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoInputFour() {
        // Arrange
        Integer expected = 29;

        // Act
        Integer actual = tt.partTwo(input4);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoInputFive() {
        // Arrange
        Integer expected = 26;

        // Act
        Integer actual = tt.partTwo(input5);

        // Assert
        assertEquals(expected, actual);
    }
}
