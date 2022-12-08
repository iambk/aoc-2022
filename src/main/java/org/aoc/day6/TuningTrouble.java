package org.aoc.day6;

import org.aoc.AOC;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TuningTrouble implements AOC<String, Integer> {
    private static final int PART_ONE_LIMIT = 4;
    private static final int PART_TWO_LIMIT = 14;

    public static void main(String[] args) {
        TuningTrouble tt = new TuningTrouble();

        // Process input
        String input = tt.processInput(AOC.getInput("src/main/resources/day6.txt"));

        // Part 1
        System.out.println(tt.partOne(input));

        // Part 2
        System.out.println(tt.partTwo(input));
    }

    @Override
    public String processInput(Stream<String> input) {
        return input.toList().get(0);
    }

    @Override
    public Integer partOne(String input) {
        for (int i = 0; i < input.length() - PART_ONE_LIMIT; i++) {
            int uniqueChars = input.substring(i, i + PART_ONE_LIMIT)
                    .chars()
                    .mapToObj(ch -> (char) ch)
                    .collect(Collectors.toSet())
                    .size();
            if (uniqueChars == PART_ONE_LIMIT) return i + PART_ONE_LIMIT;
        }
        return 0;
    }

    @Override
    public Integer partTwo(String input) {
        for (int i = 0; i < input.length() - PART_TWO_LIMIT; i++) {
            int uniqueChars = input.substring(i, i + PART_TWO_LIMIT)
                    .chars()
                    .mapToObj(ch -> (char) ch)
                    .collect(Collectors.toSet())
                    .size();
            if (uniqueChars == PART_TWO_LIMIT) return i + PART_TWO_LIMIT;
        }
        return 0;
    }
}
