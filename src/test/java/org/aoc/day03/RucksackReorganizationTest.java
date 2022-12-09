package org.aoc.day03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RucksackReorganizationTest {
    RucksackReorganization rr;
    List<String> input;

    @BeforeEach
    void setUp() {
        rr = new RucksackReorganization();
        input = List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw");
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        Stream<String> input = Stream.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        List<String> expectedInput = List.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");

        // Act
        List<String> processedInput = rr.processInput(input);

        // Assert
        assertEquals(expectedInput, processedInput);
    }

    @Test
    void shouldReturnPriorityItemPartOne() {
        // Arrange
        String input = "vJrwpWtwJgWrhcsFMMfFFhFp";
        Character expected = 'p';

        // Act
        Character actual = rr.getPriorityItemPartOne(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnPriorityValueForItemPartOne() {
        // Arrange
        Character input = 'p';
        int expected = 16;

        // Act
        int actual = rr.getPriorityValue(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldCountPriorityPartOne() {
        // Arrange
        int expected = 157;

        // Act
        int actual = rr.partOne(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnPriorityItemPartTwo() {
        // Arrange
        List<String> input = List.of("vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg");
        Character expected = 'r';

        // Act
        Character actual = rr.getPriorityItemPartTwo(input);

        // Assert
        assertEquals(expected, actual);
    }


    @Test
    void shouldCountPriorityPartTwo() {
        // Arrange
        int expected = 70;

        // Act
        int actual = rr.partTwo(input);

        // Assert
        assertEquals(expected, actual);
    }
}
