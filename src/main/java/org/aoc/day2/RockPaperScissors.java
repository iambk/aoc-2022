package org.aoc.day2;

import org.aoc.utils.FileReader;

import java.io.IOException;
import java.util.List;

public class RockPaperScissors {
    private static final String ROCK = "X";
    private static final String PAPER = "Y";
    private static final String SCISSORS = "Z";
    private static final String LOSS = "X";
    private static final String DRAW = "Y";
    private static final String WIN = "Z";

    private static int returnScorePartOne(String opponentMove, String myMove) {
        int score = 0;
        if (ROCK.equals(myMove)) {
            score += Constants.X;
            if (Constants.ROCK.equals(opponentMove)) score += Constants.DRAW;
            if (Constants.PAPER.equals(opponentMove)) score += Constants.LOSE;
            if (Constants.SCISSORS.equals(opponentMove)) score += Constants.WIN;
        } else if (PAPER.equals(myMove)) {
            score += Constants.Y;
            if (Constants.ROCK.equals(opponentMove)) score += Constants.WIN;
            if (Constants.PAPER.equals(opponentMove)) score += Constants.DRAW;
            if (Constants.SCISSORS.equals(opponentMove)) score += Constants.LOSE;
        } else if (SCISSORS.equals(myMove)) {
            score += Constants.Z;
            if (Constants.ROCK.equals(opponentMove)) score += Constants.LOSE;
            if (Constants.PAPER.equals(opponentMove)) score += Constants.WIN;
            if (Constants.SCISSORS.equals(opponentMove)) score += Constants.DRAW;
        }
        return score;
    }

    private static int returnScorePartTwo(String opponentMove, String desiredResult) {
        int score = 0;
        if (LOSS.equals(desiredResult)) {
            score += Constants.LOSE;
            if (Constants.ROCK.equals(opponentMove)) score += Constants.Z;
            if (Constants.PAPER.equals(opponentMove)) score += Constants.X;
            if (Constants.SCISSORS.equals(opponentMove)) score += Constants.Y;
        } else if (DRAW.equals(desiredResult)) {
            score += Constants.DRAW;
            if (Constants.ROCK.equals(opponentMove)) score += Constants.X;
            if (Constants.PAPER.equals(opponentMove)) score += Constants.Y;
            if (Constants.SCISSORS.equals(opponentMove)) score += Constants.Z;
        } else if (WIN.equals(desiredResult)) {
            score += Constants.WIN;
            if (Constants.ROCK.equals(opponentMove)) score += Constants.Y;
            if (Constants.PAPER.equals(opponentMove)) score += Constants.Z;
            if (Constants.SCISSORS.equals(opponentMove)) score += Constants.X;
        }
        return score;
    }

    public static int evaluatePartOne(String filePath) throws IOException {
        List<String[]> inputs = getInputs(filePath);

        int totalScore = 0;
        for (String[] input : inputs) {
            totalScore += returnScorePartOne(input[0], input[1]);
        }

        return totalScore;
    }

    public static int evaluatePartTwo(String filePath) throws IOException {
        List<String[]> inputs = getInputs(filePath);

        int totalScore = 0;
        for (String[] input : inputs) {
            totalScore += returnScorePartTwo(input[0], input[1]);
        }

        return totalScore;
    }

    private static List<String[]> getInputs(String filePath) throws IOException {
        return FileReader.getLines(filePath)
                .map(s -> s.split(" "))
                .toList();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(evaluatePartOne("src/main/resources/day2.txt"));
        System.out.println(evaluatePartTwo("src/main/resources/day2.txt"));
    }
}
