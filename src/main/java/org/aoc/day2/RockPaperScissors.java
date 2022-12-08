package org.aoc.day2;

import org.aoc.utils.FileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RockPaperScissors {
    private static final String OPPONENT_ROCK_MOVE = "A";
    private static final String OPPONENT_PAPER_MOVE = "B";
    private static final String OPPONENT_SCISSORS_MOVE = "C";
    private static final String MY_ROCK_MOVE = "X";
    private static final String MY_PAPER_MOVE = "Y";
    private static final String MY_SCISSORS_MOVE = "Z";
    private static final Map<List<String>, Result> RESULT_MAP = Map.ofEntries(
            Map.entry(List.of(OPPONENT_ROCK_MOVE, MY_ROCK_MOVE), Result.DRAW),
            Map.entry(List.of(OPPONENT_ROCK_MOVE, MY_PAPER_MOVE), Result.WIN),
            Map.entry(List.of(OPPONENT_ROCK_MOVE, MY_SCISSORS_MOVE), Result.LOSE),
            Map.entry(List.of(OPPONENT_PAPER_MOVE, MY_ROCK_MOVE), Result.LOSE),
            Map.entry(List.of(OPPONENT_PAPER_MOVE, MY_PAPER_MOVE), Result.DRAW),
            Map.entry(List.of(OPPONENT_PAPER_MOVE, MY_SCISSORS_MOVE), Result.WIN),
            Map.entry(List.of(OPPONENT_SCISSORS_MOVE, MY_ROCK_MOVE), Result.WIN),
            Map.entry(List.of(OPPONENT_SCISSORS_MOVE, MY_PAPER_MOVE), Result.LOSE),
            Map.entry(List.of(OPPONENT_SCISSORS_MOVE, MY_SCISSORS_MOVE), Result.DRAW)
    );
    private static final String LOSS = "X";
    private static final String DRAW = "Y";
    private static final String WIN = "Z";
    private static final Map<List<String>, String> MOVE_MAP = Map.ofEntries(
            Map.entry(List.of(OPPONENT_ROCK_MOVE, DRAW), MY_ROCK_MOVE),
            Map.entry(List.of(OPPONENT_ROCK_MOVE, WIN), MY_PAPER_MOVE),
            Map.entry(List.of(OPPONENT_ROCK_MOVE, LOSS), MY_SCISSORS_MOVE),
            Map.entry(List.of(OPPONENT_PAPER_MOVE, LOSS), MY_ROCK_MOVE),
            Map.entry(List.of(OPPONENT_PAPER_MOVE, DRAW), MY_PAPER_MOVE),
            Map.entry(List.of(OPPONENT_PAPER_MOVE, WIN), MY_SCISSORS_MOVE),
            Map.entry(List.of(OPPONENT_SCISSORS_MOVE, WIN), MY_ROCK_MOVE),
            Map.entry(List.of(OPPONENT_SCISSORS_MOVE, LOSS), MY_PAPER_MOVE),
            Map.entry(List.of(OPPONENT_SCISSORS_MOVE, DRAW), MY_SCISSORS_MOVE)
    );

    public static int evaluatePartOne(List<List<String>> inputs) {
        int totalScore = 0;
        for (List<String> move : inputs) {
            String myMove = move.get(1);
            String result = RESULT_MAP.get(move).name();

            totalScore += Score.valueOf(myMove).getScore() + Score.valueOf(result).getScore();
        }

        return totalScore;
    }

    public static int evaluatePartTwo(List<List<String>> inputs) {
        int totalScore = 0;
        for (List<String> move : inputs) {
            String myMove = MOVE_MAP.get(move);
            String result = RESULT_MAP.get(List.of(move.get(0), myMove)).name();
            totalScore += Score.valueOf(myMove).getScore() + Score.valueOf(result).getScore();
        }

        return totalScore;
    }

    public static List<List<String>> processInput(String filePath) throws IOException {
        return FileReader.getLines(filePath)
                .map(s -> s.split(" "))
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<List<String>> inputs = processInput("src/main/resources/day2.txt");

        // Part 1
        System.out.println(evaluatePartOne(inputs));

        // Part 2
        System.out.println(evaluatePartTwo(inputs));
    }
}
