package org.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonkeyInTheMiddleTest {
    Stream<String> input;
    List<Monkey> monkeys;

    @BeforeEach
    void setUp() {
        input = Stream.of("Monkey 0:",
                "  Starting items: 79, 98",
                "  Operation: new = old * 19",
                "  Test: divisible by 23",
                "    If true: throw to monkey 2",
                "    If false: throw to monkey 3",
                "",
                "Monkey 1:",
                "  Starting items: 54, 65, 75, 74",
                "  Operation: new = old + 6",
                "  Test: divisible by 19",
                "    If true: throw to monkey 2",
                "    If false: throw to monkey 0",
                "",
                "Monkey 2:",
                "  Starting items: 79, 60, 97",
                "  Operation: new = old * old",
                "  Test: divisible by 13",
                "    If true: throw to monkey 1",
                "    If false: throw to monkey 3",
                "",
                "Monkey 3:",
                "  Starting items: 74",
                "  Operation: new = old + 3",
                "  Test: divisible by 17",
                "    If true: throw to monkey 0",
                "    If false: throw to monkey 1");
        Monkey monkey0 =
                new Monkey(
                        new ArrayList<>(List.of(79L, 98L)),
                        "*",
                        "19",
                        23,
                        2,
                        3,
                        0L);
        Monkey monkey1 =
                new Monkey(
                        new ArrayList<>(List.of(54L, 65L, 75L, 74L)),
                        "+",
                        "6",
                        19,
                        2,
                        0,
                        0L);
        Monkey monkey2 =
                new Monkey(
                        new ArrayList<>(List.of(79L, 60L, 97L)),
                        "*",
                        "old",
                        13,
                        1,
                        3,
                        0L);
        Monkey monkey3 =
                new Monkey(
                        new ArrayList<>(List.of(74L)),
                        "+",
                        "3",
                        17,
                        0,
                        1,
                        0L);
        monkeys = List.of(monkey0, monkey1, monkey2, monkey3);
    }

    @Test
    void shouldProcessInput() {
        // Arrange
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(20, 10000);

        // Act
        List<Monkey> actualMonkeys = mitm.processInput(input);

        // Assert
        assertEquals(monkeys, actualMonkeys);
    }

    @Test
    void shouldEvaluatePartOneForOneRound() {
        // Arrange
        Long expected = 20L;
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(1, 1);

        // Act
        Long actual = mitm.partOne(monkeys);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartOneForTwentyRounds() {
        // Arrange
        Long expected = 10605L;
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(20, 1);


        // Act
        Long actual = mitm.partOne(monkeys);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoForTwentyRounds() {
        // Arrange
        Long expected = 10197L;
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(20, 20);

        // Act
        Long actual = mitm.partTwo(monkeys);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoForThousandRounds() {
        // Arrange
        Long expected = 27019168L;
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(20, 1000);


        // Act
        Long actual = mitm.partTwo(monkeys);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoForNineThousandRounds() {
        // Arrange
        Long expected = 2197354615L;
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(20, 9000);


        // Act
        Long actual = mitm.partTwo(monkeys);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldEvaluatePartTwoForTenThousandRounds() {
        // Arrange
        Long expected = 2713310158L;
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(20, 10000);


        // Act
        Long actual = mitm.partTwo(monkeys);

        // Assert
        assertEquals(expected, actual);
    }
}
