package org.aoc.day09;

import org.aoc.AOC;

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
        Position startingPosition = new Position(0, 0);
        Knot tail = new Knot(null, startingPosition);
        Knot head = new Knot(tail, startingPosition);
        List<Knot> rope = List.of(head, tail);
        return getTailVisits(input, rope);
    }

    @Override
    public Integer partTwo(List<List<String>> input) {
        Position startingPosition = new Position(0, 0);
        Knot knot9 = new Knot(null, startingPosition);
        Knot knot8 = new Knot(knot9, startingPosition);
        Knot knot7 = new Knot(knot8, startingPosition);
        Knot knot6 = new Knot(knot7, startingPosition);
        Knot knot5 = new Knot(knot6, startingPosition);
        Knot knot4 = new Knot(knot5, startingPosition);
        Knot knot3 = new Knot(knot4, startingPosition);
        Knot knot2 = new Knot(knot3, startingPosition);
        Knot knot1 = new Knot(knot2, startingPosition);
        Knot head = new Knot(knot1, startingPosition);
        List<Knot> rope = List.of(head, knot1, knot2, knot3, knot4, knot5, knot6, knot7, knot8, knot9);
        return getTailVisits(input, rope);
    }

    private int getTailVisits(List<List<String>> input, List<Knot> rope) {
        return input.stream()
                .map(command -> process(command, rope))
                .flatMap(Set::stream)
                .collect(Collectors.toSet())
                .size();
    }

    private Set<Position> process(List<String> command, List<Knot> rope) {
        return IntStream.range(0, Integer.parseInt(command.get(1)))
                .mapToObj(idx -> {
                    rope.get(0).move(command.get(0));
                    rope.forEach(Knot::pull);
                    return rope.get(rope.size() - 1).getPosition();
                }).collect(Collectors.toSet());
    }
}
