package org.aoc.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplyStacksTest {
    SupplyStacks ss;
    Stack<Character> s1;
    Stack<Character> s2;
    Stack<Character> s3;
    List<List<Integer>> input;

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
        ss = new SupplyStacks(List.of(s1, s2, s3));
        input = List.of(
                List.of(1, 2, 1),
                List.of(3, 1, 3),
                List.of(2, 2, 1),
                List.of(1, 1, 2)
        );
    }

    @Test
    void shouldProcessMove() {
        // Arrange
        Stream<String> move = Stream.of("move 1 from 2 to 3", "move 3 from 1 to 3");
        List<List<Integer>> expectedInput = List.of(List.of(1, 2, 3), List.of(3, 1, 3));

        // Act
        List<List<Integer>> processedInput = ss.processInput(move);

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
        ss.rearrangePartOne(List.of(1, 2, 1));

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
        String actual = ss.partOne(input);

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
        SupplyStacks ss = new SupplyStacks(List.of(s1, s2, s3));
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
        ss.rearrangePartTwo(List.of(3, 1, 3));

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
        String actual = ss.partTwo(input);

        // Assert
        assertEquals(expected, actual);
    }
}
