package org.aoc.day3;

import org.aoc.AOC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RucksackReorganizationTest {
    List<String> input;
    RucksackReorganization rr;

    @BeforeEach
    void setUp() {
        input = AOC.getInput("src/test/resources/day3.txt");
        rr = new RucksackReorganization();
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
