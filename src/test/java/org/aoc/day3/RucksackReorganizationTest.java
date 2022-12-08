package org.aoc.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RucksackReorganizationTest {
    String s1 = "vJrwpWtwJgWrhcsFMMfFFhFp";
    String s2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
    String s3 = "PmmdzqPrVvPwwTWBwg";
    String s4 = "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn";
    String s5 = "ttgJtRGJQctTZtZT";
    String s6 = "CrZsJsPPZsGzwwsLwLmpwMDw";
    List<String> input;

    @BeforeEach
    void setUp() {
        input = List.of(s1, s2, s3, s4, s5, s6);
    }

    @Test
    void shouldProcessInput() throws IOException {
        // Act
        List<String> processedInput = RucksackReorganization.processInput("src/test/resources/day3.txt");

        // Assert
        assertEquals(input, processedInput);
    }

    @Test
    void shouldReturnPriorityItemPartOne() {
        // Arrange
        Character expected = 'p';

        // Act
        Character actual = RucksackReorganization.getPriorityItemPartOne(s1);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnPriorityValueForItemPartOne() {
        // Arrange
        Character input = 'p';
        int expected = 16;

        // Act
        int actual = RucksackReorganization.getPriorityValue(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldCountPriorityPartOne() {
        // Arrange
        int expected = 157;

        // Act
        int actual = RucksackReorganization.countPriorityPartOne(input);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnPriorityItemPartTwo() {
        // Arrange
        List<String> input = List.of(s1, s2, s3);
        Character expected = 'r';

        // Act
        Character actual = RucksackReorganization.getPriorityItemPartTwo(input);

        // Assert
        assertEquals(expected, actual);
    }


    @Test
    void shouldCountPriorityPartTwo() {
        // Arrange
        int expected = 70;

        // Act
        int actual = RucksackReorganization.countPriorityPartTwo(input);

        // Assert
        assertEquals(expected, actual);
    }
}
