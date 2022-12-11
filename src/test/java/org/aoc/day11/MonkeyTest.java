package org.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonkeyTest {
    Monkey monkey;

    @BeforeEach
    void setUp() {
        List<Long> items = new ArrayList<>(List.of(2L, 3L));
        String operator = "*";
        String operationValue = "19";
        Integer divisibilityTest = 23;
        Integer truthMonkey = 2;
        Integer falseMonkey = 3;
        Long inspects = 0L;
        monkey = new Monkey(items, operator, operationValue, divisibilityTest, truthMonkey, falseMonkey, inspects);
    }

    @Test
    void shouldCatchItem() {
        // Act
        monkey.catchItem(4L);

        // Assert
        assertEquals(3, monkey.getItemsSize());
        assertEquals(2, monkey.getItem(0));
        assertEquals(3, monkey.getItem(1));
        assertEquals(4, monkey.getItem(2));
    }

    @Test
    void shouldClearItems() {
        // Act
        monkey.clearItems();

        // Assert
        assertEquals(0, monkey.getItemsSize());
    }

    @Test
    void shouldTestDivisibilityAndReturnFalseMonkey() {
        // Arrange
        Integer expected = 3;

        // Act
        Integer actual = monkey.test(0);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestDivisibilityAndReturnTruthMonkey() {
        // Arrange
        Integer expected = 2;
        monkey.catchItem(23L);

        // Act
        Integer actual = monkey.test(2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReduceWorryByThree() {
        // Arrange
        Long expected = 1L;

        // Act
        monkey.reduceWorry(1);

        assertEquals(expected, monkey.getItem(1));
    }

    @Test
    void shouldOperateAndMultiply() {
        // Arrange
        Long expected = 38L;

        // Act
        monkey.operateWithMod(0, 107);

        // Assert
        assertEquals(expected, monkey.getItem(0));
    }

    @Test
    void shouldOperateAndAdd() {
        // Arrange
        Monkey monkey = new Monkey(new ArrayList<>(List.of(2L, 3L)), "+", "19", 23, 2, 3, 0L);
        Long expected = 22L;

        // Act
        monkey.operateWithMod(1, 107);

        // Assert
        assertEquals(expected, monkey.getItem(1));
    }

    @Test
    void shouldOperateWhenItemIsOld() {
        // Arrange
        Monkey monkey = new Monkey(new ArrayList<>(List.of(2L, 4L)), "*", "old", 23, 2, 3, 0L);
        Long expected = 16L;

        // Act
        monkey.operateWithMod(1, 107);

        // Assert
        assertEquals(expected, monkey.getItem(1));
    }

    @Test
    void shouldInspect() {
        // Arrange
        Long expectedInspects = 1L;

        // Act
        monkey.inspect(0, 107);

        // Assert
        assertEquals(expectedInspects, monkey.getInspects());
    }
}
