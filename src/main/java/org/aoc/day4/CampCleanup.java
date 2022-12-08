package org.aoc.day4;

import org.aoc.AOC;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CampCleanup implements AOC<List<List<Integer>>, Long> {
    public static void main(String[] args) {
        CampCleanup cc = new CampCleanup();

        // Process input
        List<List<Integer>> input = cc.processInput(AOC.getInput("src/main/resources/day4.txt"));

        // Part 1
        System.out.println(cc.partOne(input));

        // Part 2
        System.out.println(cc.partTwo(input));
    }

    @Override
    public List<List<Integer>> processInput(Stream<String> input) {
        return input.map(s -> s.split("[-,]"))
                .map(strings -> Arrays.stream(strings)
                        .map(Integer::parseInt)
                        .toList())
                .toList();
    }

    @Override
    public Long partOne(List<List<Integer>> input) {
        return input.stream()
                .filter(this::encompassesPartOne)
                .count();
    }

    @Override
    public Long partTwo(List<List<Integer>> input) {
        return input.stream()
                .filter(this::encompassesPartTwo)
                .count();
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
