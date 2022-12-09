package org.aoc.day9;

import org.aoc.AOC;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RopeBridge implements AOC<List<List<String>>, Integer> {
    public static void main(String[] args) {
        RopeBridge rb = new RopeBridge();

        // Process input
        List<List<String>> input = rb.processInput(AOC.getInput("src/main/resources/day9.txt"));

        // Part 1
        System.out.println(rb.partOne(input));

        // Part 2
        System.out.println(rb.partTwo(input));
    }

    @Override
    public List<List<String>> processInput(Stream<String> input) {
        return input.map(command -> Arrays.asList(command.split(" ")))
                .toList();
    }

    @Override
    public Integer partOne(List<List<String>> input) {
        Head head = new Head();
        Tail tail = new Tail(head);
        List<Tail> tailList = List.of(tail);
        return getTailVisits(input, head, tailList);
    }

    @Override
    public Integer partTwo(List<List<String>> input) {
        Head head = new Head();
        Tail tail1 = new Tail(head);
        Tail tail2 = new Tail(tail1);
        Tail tail3 = new Tail(tail2);
        Tail tail4 = new Tail(tail3);
        Tail tail5 = new Tail(tail4);
        Tail tail6 = new Tail(tail5);
        Tail tail7 = new Tail(tail6);
        Tail tail8 = new Tail(tail7);
        Tail tail9 = new Tail(tail8);
        List<Tail> tailList = List.of(tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9);
        return getTailVisits(input, head, tailList);
    }

    private int getTailVisits(List<List<String>> input, Head head, List<Tail> tailList) {
        return input.stream()
                .map(command -> process(command, head, tailList))
                .flatMap(Set::stream)
                .collect(Collectors.toSet())
                .size();
    }

    private Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> process(
            List<String> command, Head head, List<Tail> tailList) {
        return IntStream.range(0, Integer.parseInt(command.get(1)))
                .mapToObj(idx -> {
                    head.move(command.get(0));
                    for (Tail tail : tailList) tail.realign();
                    return getTailPosition(tailList.get(tailList.size() - 1));
                }).collect(Collectors.toSet());
    }

    private AbstractMap.SimpleImmutableEntry<Integer, Integer> getTailPosition(Tail tail) {
        return new AbstractMap.SimpleImmutableEntry<>(tail.getXPosition(), tail.getYPosition());
    }
}
