package org.aoc.day2;

import org.aoc.AOC;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.aoc.day2.Constants.MOVE_MAP;
import static org.aoc.day2.Constants.RESULT_MAP;

public class RockPaperScissors implements AOC<List<List<String>>, Integer> {
    public static void main(String[] args) {
        RockPaperScissors rps = new RockPaperScissors();

        // Process input
        List<List<String>> input = rps.processInput(AOC.getInput("src/main/resources/day2.txt"));

        // Part 1
        System.out.println(rps.partOne(input));

        // Part 2
        System.out.println(rps.partTwo(input));
    }

    @Override
    public List<List<String>> processInput(Stream<String> input) {
        return input.map(s -> s.split(" "))
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }

    @Override
    public Integer partOne(List<List<String>> input) {
        return input.stream()
                .map(RockPaperScissors::getScorePartOne)
                .reduce(0, Integer::sum);
    }

    @Override
    public Integer partTwo(List<List<String>> input) {
        return input.stream()
                .map(RockPaperScissors::getScorePartTwo)
                .reduce(0, Integer::sum);
    }

    private static Integer getScorePartOne(List<String> move) {
        String myMove = move.get(1);
        String result = RESULT_MAP.get(move).name();
        return Score.valueOf(myMove).getScore() + Score.valueOf(result).getScore();
    }

    private static int getScorePartTwo(List<String> move) {
        String myMove = MOVE_MAP.get(move);
        String result = RESULT_MAP.get(List.of(move.get(0), myMove)).name();
        return Score.valueOf(myMove).getScore() + Score.valueOf(result).getScore();
    }
}
