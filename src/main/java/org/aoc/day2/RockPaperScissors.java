package org.aoc.day2;

import org.aoc.AOC;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.aoc.day2.Constants.MOVE_MAP;
import static org.aoc.day2.Constants.RESULT_MAP;

public class RockPaperScissors implements AOC<Integer> {
    public static void main(String[] args) {
        List<String> input = AOC.getInput("src/main/resources/day2.txt");
        RockPaperScissors rps = new RockPaperScissors();

        // Part 1
        System.out.println(rps.partOne(input));

        // Part 2
        System.out.println(rps.partTwo(input));
    }

    @Override
    public Integer partOne(List<String> input) {
        return processInput(input)
                .stream()
                .map(RockPaperScissors::getScorePartOne)
                .reduce(0, Integer::sum);
    }

    @Override
    public Integer partTwo(List<String> input) {
        return processInput(input)
                .stream()
                .map(RockPaperScissors::getScorePartTwo)
                .reduce(0, Integer::sum);
    }

    public List<List<String>> processInput(List<String> input) {
        return input.stream()
                .map(s -> s.split(" "))
                .map(Arrays::asList)
                .collect(Collectors.toList());
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
