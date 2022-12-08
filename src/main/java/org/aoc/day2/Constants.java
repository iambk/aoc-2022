package org.aoc.day2;

import java.util.List;
import java.util.Map;

public class Constants {
    public static final String OPPONENT_ROCK_MOVE = "A";
    public static final String OPPONENT_PAPER_MOVE = "B";
    public static final String OPPONENT_SCISSORS_MOVE = "C";
    public static final String MY_ROCK_MOVE = "X";
    public static final String MY_PAPER_MOVE = "Y";
    public static final String MY_SCISSORS_MOVE = "Z";
    public static final Map<List<String>, Result> RESULT_MAP = Map.ofEntries(
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
    public static final String LOSS = "X";
    public static final String DRAW = "Y";
    public static final String WIN = "Z";
    public static final Map<List<String>, String> MOVE_MAP = Map.ofEntries(
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
}
