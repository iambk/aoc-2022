package org.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonkeyTest {
    Monkey monkey;

    @BeforeEach
    void setUp() {
        Queue<Item> items = new ArrayDeque<>(List.of(new Item(2L), new Item(3L)));
        String operator = "*";
        String operationValue = "19";
        int divisibilityTest = 23;
        int truthMonkey = 2;
        int falseMonkey = 3;
        long inspects = 0L;
        monkey = new Monkey(items, operator, operationValue, divisibilityTest, truthMonkey, falseMonkey, inspects);
    }

    @Test
    void shouldTestDivisibilityAndReturnFalseMonkey() {
        // Arrange
        Integer expected = 3;

        // Act
        Integer actual = monkey.testDivisibility();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestDivisibilityAndReturnTruthMonkey() {
        // Arrange
        Monkey monkey = new Monkey(new ArrayDeque<>(List.of(new Item(23L))), "+", "19", 23, 2, 3, 0L);
        Integer expected = 2;

        // Act
        Integer actual = monkey.testDivisibility();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldInspectAndMultiply() {
        // Arrange
        Long expectedInspects = 1L;
        Long expectedItemWorryLevel = 38L;

        // Act
        monkey.inspect();

        // Assert
        assertEquals(expectedInspects, monkey.getInspects());
        assertEquals(expectedItemWorryLevel, monkey.peekItem().getWorryLevel());
    }


    @Test
    void shouldInspectAndAdd() {
        // Arrange
        Monkey monkey = new Monkey(new ArrayDeque<>(List.of(new Item(3L))), "+", "19", 23, 2, 3, 0L);
        Long expectedInspects = 1L;
        Long expectedItemWorryLevel = 22L;

        // Act
        monkey.inspect();

        // Assert
        assertEquals(expectedInspects, monkey.getInspects());
        assertEquals(expectedItemWorryLevel, monkey.peekItem().getWorryLevel());
    }

    @Test
    void shouldInspectWhenOperandIsOld() {
        // Arrange
        Monkey monkey = new Monkey(new ArrayDeque<>(List.of(new Item(4L))), "*", "old", 23, 2, 3, 0L);
        Long expectedInspects = 1L;
        Long expectedItemWorryLevel = 16L;

        // Act
        monkey.inspect();

        // Assert
        assertEquals(expectedInspects, monkey.getInspects());
        assertEquals(expectedItemWorryLevel, monkey.peekItem().getWorryLevel());
    }
}
