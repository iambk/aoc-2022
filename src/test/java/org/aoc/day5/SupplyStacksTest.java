package org.aoc.day5;

import org.aoc.AOC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplyStacksTest {
    Stack<Character> s1;
    Stack<Character> s2;
    Stack<Character> s3;
    List<String> input;
    SupplyStacks df;

    @BeforeEach
    void setUp() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        s3 = new Stack<>();
        s1.push('Z');
        s1.push('N');
        s2.push('M');
        s2.push('C');
        s2.push('D');
        s3.push('P');
        input = AOC.getInput("src/test/resources/day5.txt");
        df = new SupplyStacks(List.of(s1, s2, s3));
    }

    @Test
    void shouldProcessMove() {
        // Arrange
        String move = "move 1 from 2 to 3";
        List<Integer> expectedInput = List.of(1, 2, 3);

        // Act
        List<Integer> processedInput = df.processMove(move);

        // Assert
        assertEquals(expectedInput, processedInput);
    }

    @Test
    void shouldRearrangeStackForPartOne() {
        // Arrange
        Stack<Character> expectedS1 = new Stack<>();
        Stack<Character> expectedS2 = new Stack<>();
        Stack<Character> expectedS3 = new Stack<>();
        expectedS1.push('Z');
        expectedS1.push('N');
        expectedS1.push('D');
        expectedS2.push('M');
        expectedS2.push('C');
        expectedS3.push('P');

        // Act
        df.rearrangePartOne(List.of(1, 2, 1));

        // Assert
        assertEquals(expectedS1, s1);
        assertEquals(expectedS2, s2);
        assertEquals(expectedS3, s3);
    }

    @Test
    void shouldEvaluatePartOne() {
        // Arrange
        String expected = "CMZ";

        // Act
        String actual = df.partOne(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldRearrangeStackForPartTwo() {
        // Arrange
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        Stack<Character> s3 = new Stack<>();
        s1.push('Z');
        s1.push('N');
        s1.push('D');
        s2.push('M');
        s2.push('C');
        s3.push('P');
        SupplyStacks df = new SupplyStacks(List.of(s1, s2, s3));
        Stack<Character> expectedS1 = new Stack<>();
        Stack<Character> expectedS2 = new Stack<>();
        Stack<Character> expectedS3 = new Stack<>();
        expectedS2.push('M');
        expectedS2.push('C');
        expectedS3.push('P');
        expectedS3.push('Z');
        expectedS3.push('N');
        expectedS3.push('D');

        // Act
        df.rearrangePartTwo(List.of(3, 1, 3));

        // Assert
        assertEquals(expectedS1, s1);
        assertEquals(expectedS2, s2);
        assertEquals(expectedS3, s3);
    }

    @Test
    void shouldEvaluatePartTwo() {
        // Arrange
        String expected = "MCD";

        // Act
        String actual = df.partTwo(input);

        // Assert
        assertEquals(expected, actual);
    }
}
