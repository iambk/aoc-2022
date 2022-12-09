package org.aoc.day03;

import org.aoc.AOC;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RucksackReorganization implements AOC<List<String>, Integer> {
    public static void main(String[] args) {
        RucksackReorganization rr = new RucksackReorganization();

        // Process input
        List<String> input = rr.processInput(AOC.getInput("src/main/resources/day3.txt"));

        // Part 1
        System.out.println(rr.partOne(input));

        // Part 2
        System.out.println(rr.partTwo(input));
    }

    @Override
    public List<String> processInput(Stream<String> input) {
        return input.toList();
    }

    @Override
    public Integer partOne(List<String> input) {
        return input.stream()
                .map(this::getPriorityItemPartOne)
                .map(this::getPriorityValue)
                .reduce(0, Integer::sum);
    }

    @Override
    public Integer partTwo(List<String> input) {
        return IntStream.range(0, input.size() / 3)
                .map(index -> index * 3)
                .map(index -> getPriorityItemPartTwo(input.subList(index, index + 3)))
                .mapToObj(ch -> (char) ch)
                .map(this::getPriorityValue)
                .reduce(0, Integer::sum);
    }

    public Character getPriorityItemPartOne(String input) {
        String part1 = input.substring(0, input.length() / 2);
        String part2 = input.substring(input.length() / 2);

        //noinspection OptionalGetWithoutIsPresent
        return part1.chars()
                .filter(ch -> part2.indexOf(ch) != -1)
                .mapToObj(asciiValue -> (char) asciiValue)
                .findFirst()
                .get();
    }

    public Character getPriorityItemPartTwo(List<String> input) {
        String s1 = input.get(0);
        String s2 = input.get(1);
        String s3 = input.get(2);

        //noinspection OptionalGetWithoutIsPresent
        return s1.chars()
                .filter(ch -> (s2.indexOf(ch) != -1 && s3.indexOf(ch) != -1))
                .mapToObj(asciiValue -> (char) asciiValue)
                .findFirst()
                .get();
    }

    public int getPriorityValue(Character input) {
        if (Character.isLowerCase(input)) return input - 96;
        else return input - 38;
    }
}
