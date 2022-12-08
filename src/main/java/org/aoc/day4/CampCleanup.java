package org.aoc.day4;

import org.aoc.AOC;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CampCleanup implements AOC<Long> {
    public static void main(String[] args) {
        List<String> input = AOC.getInput("src/main/resources/day4.txt");
        CampCleanup cc = new CampCleanup();

        // Part 1
        System.out.println(cc.partOne(input));

        // Part 2
        System.out.println(cc.partTwo(input));
    }

    @Override
    public Long partOne(List<String> input) {
        return processInput(input)
                .filter(this::encompassesPartOne)
                .count();
    }

    @Override
    public Long partTwo(List<String> input) {
        return processInput(input)
                .filter(this::encompassesPartTwo)
                .count();
    }

    public static Stream<List<Integer>> processInput(List<String> input) {
        return input.stream()
                .map(s -> s.split("[-,]"))
                .map(strings -> Arrays.stream(strings)
                        .map(Integer::parseInt)
                        .toList());
    }

    private boolean encompassesPartOne(List<Integer> pair) {
        Integer p1 = pair.get(0);
        Integer p2 = pair.get(1);
        Integer p3 = pair.get(2);
        Integer p4 = pair.get(3);
        if (p1 >= p3 && p1 <= p4 && p2 >= p3 && p2 <= p4) return true;
        return p3 >= p1 && p3 <= p2 && p4 >= p1 && p4 <= p2;
    }

    private boolean encompassesPartTwo(List<Integer> pair) {
        Integer p1 = pair.get(0);
        Integer p2 = pair.get(1);
        Integer p3 = pair.get(2);
        Integer p4 = pair.get(3);
        if ((p1 >= p3 && p1 <= p4) || (p2 >= p3 && p2 <= p4)) return true;
        return ((p3 >= p1 && p3 <= p2) || (p4 >= p1 && p4 <= p2));
    }
}
