package org.aoc.day11;

import org.aoc.AOC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class MonkeyInTheMiddle implements AOC<List<Monkey>, Long> {
    private final int partOneRounds;
    private final int partTwoRounds;

    public MonkeyInTheMiddle(int partOneRounds, int partTwoRounds) {
        this.partOneRounds = partOneRounds;
        this.partTwoRounds = partTwoRounds;
    }

    public static void main(String[] args) {
        MonkeyInTheMiddle mitm = new MonkeyInTheMiddle(20, 10000);

        // Process input
        List<Monkey> monkeys = mitm.processInput(AOC.getInput("src/main/resources/day11.txt"));

        // Part 1
        System.out.println(mitm.partOne(monkeys));

        // Part 2 (comment partOne to ensure modified monkeys are not passed)
        System.out.println(mitm.partTwo(monkeys));
    }

    @Override
    public List<Monkey> processInput(Stream<String> input) {
        List<String> inputList = input.filter(s -> !s.isBlank()).toList();

        List<Long> items = null;
        String operator = null;
        String operationValue = null;
        int divisibilityTest = 0;
        int truthMonkey = 0;
        int falseMonkey;
        Long inspects = 0L;

        List<Monkey> monkeys = new ArrayList<>();
        for (int idx = 0; idx < inputList.size(); idx++) {
            String command = inputList.get(idx);
            if (idx % 6 == 1) {
                String[] split = command.substring(command.indexOf(":") + 1).split(",");
                items = new ArrayList<>(Arrays.stream(split).map(String::trim).map(Long::parseLong).toList());
            } else if (idx % 6 == 2) {
                String[] split = command.split(" ");
                operator = split[split.length - 2];
                operationValue = split[split.length - 1];
            } else if (idx % 6 == 3) {
                String[] split = command.split(" ");
                divisibilityTest = Integer.parseInt(split[split.length - 1]);
            } else if (idx % 6 == 4) {
                String[] split = command.split(" ");
                truthMonkey = Integer.parseInt(split[split.length - 1]);
            } else if (idx % 6 == 5) {
                String[] split = command.split(" ");
                falseMonkey = Integer.parseInt(split[split.length - 1]);
                monkeys.add(
                        new Monkey(items,
                                operator,
                                operationValue,
                                divisibilityTest,
                                truthMonkey,
                                falseMonkey,
                                inspects));

            }
        }
        return monkeys;
    }

    @Override
    public Long partOne(List<Monkey> monkeys) {
        for (int round = 1; round <= partOneRounds; round++) {
            for (Monkey monkey : monkeys) {
                for (int itemIndex = 0; itemIndex < monkey.getItemsSize(); itemIndex++) {
                    monkey.inspect(itemIndex, Long.MAX_VALUE);
                    monkey.reduceWorry(itemIndex);
                    int monkeyToThrow = monkey.test(itemIndex);
                    monkeys.get(monkeyToThrow).catchItem(monkey.getItem(itemIndex));
                }
                monkey.clearItems();
            }
        }

        return getMonkeyBusiness(monkeys);
    }

    @Override
    public Long partTwo(List<Monkey> monkeys) {
        long mod = monkeys.stream()
                .map(Monkey::getDivisibilityTest)
                .map(Integer::longValue)
                .reduce(1L, (a, b) -> (a * b));

        for (int round = 1; round <= partTwoRounds; round++) {
            for (Monkey monkey : monkeys) {
                for (int itemIndex = 0; itemIndex < monkey.getItemsSize(); itemIndex++) {
                    monkey.inspect(itemIndex, mod);
                    int monkeyToThrow = monkey.test(itemIndex);
                    monkeys.get(monkeyToThrow).catchItem(monkey.getItem(itemIndex));
                }
                monkey.clearItems();
            }
        }

        return getMonkeyBusiness(monkeys);
    }

    private static Long getMonkeyBusiness(List<Monkey> monkeys) {
        Set<Long> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(monkeys.stream()
                .map(Monkey::getInspects)
                .toList());

        return sortedSet.stream()
                .limit(2)
                .reduce(1L, (a, b) -> a * b);
    }
}
