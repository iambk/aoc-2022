package org.aoc.day8;

import org.aoc.AOC;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayEight implements AOC<List<List<Integer>>, Integer> {
    public static void main(String[] args) {
        DayEight de = new DayEight();

        // Process input
        List<List<Integer>> input = de.processInput(AOC.getInput("src/main/resources/day8.txt"));

        // Part 1
        System.out.println(de.partOne(input));

        // Part 2
        System.out.println(de.partTwo(input));
    }

    @Override
    public List<List<Integer>> processInput(Stream<String> input) {
        return input.map(line ->
                        line.chars()
                                .mapToObj(num -> (char) num - '0')
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer partOne(List<List<Integer>> input) {
        Integer visibleTrees = (input.size() - 1) * 4;
        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < input.size() - 1; j++) {
                if (isVisible(i, j, input)) {
                    visibleTrees++;
                }
            }
        }
        return visibleTrees;
    }

    private boolean isVisible(int i, int j, List<List<Integer>> input) {
        return isVisibleFromTop(i, j, input)
                || isVisibleFromRight(i, j, input)
                || isVisibleFromBottom(i, j, input)
                || isVisibleFromLeft(i, j, input);
    }

    private boolean isVisibleFromTop(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        for (int topI = i - 1; topI >= 0; topI--) {
            Integer topTree = input.get(topI).get(j);
            if (tree <= topTree) return false;
        }
        return true;
    }

    private boolean isVisibleFromRight(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        for (int rightJ = j + 1; rightJ < input.size(); rightJ++) {
            Integer rightTree = input.get(i).get(rightJ);
            if (tree <= rightTree) return false;
        }
        return true;
    }

    private boolean isVisibleFromBottom(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        for (int bottomI = i + 1; bottomI < input.size(); bottomI++) {
            Integer bottomTree = input.get(bottomI).get(j);
            if (tree <= bottomTree) return false;
        }
        return true;
    }

    private boolean isVisibleFromLeft(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        for (int leftJ = j - 1; leftJ >= 0; leftJ--) {
            Integer leftTree = input.get(i).get(leftJ);
            if (tree <= leftTree) return false;
        }
        return true;
    }

    @Override
    public Integer partTwo(List<List<Integer>> input) {
        Integer maxScore = 0;
        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < input.size() - 1; j++) {
                Integer score = findViewingDistance(i, j, input);
                if (score > maxScore) maxScore = score;
            }
        }
        return maxScore;
    }

    private Integer findViewingDistance(int i, int j, List<List<Integer>> input) {
        return traverse(i, j, input);
    }

    private Integer traverse(int i, int j, List<List<Integer>> input) {
        return traverseTop(i, j, input)
                * traverseRight(i, j, input)
                * traverseBottom(i, j, input)
                * traverseLeft(i, j, input);
    }

    private Integer traverseTop(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        Integer score = 0;
        for (int topI = i - 1; topI >= 0; topI--) {
            Integer topTree = input.get(topI).get(j);
            if (tree >= topTree) score++;
            if (tree <= topTree) return score;
        }
        return score;
    }

    private Integer traverseRight(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        Integer score = 0;
        for (int rightJ = j + 1; rightJ < input.size(); rightJ++) {
            Integer rightTree = input.get(i).get(rightJ);
            if (tree >= rightTree) score++;
            if (tree <= rightTree) return score;
        }
        return score;
    }

    private Integer traverseBottom(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        Integer score = 0;
        for (int bottomI = i + 1; bottomI < input.size(); bottomI++) {
            Integer bottomTree = input.get(bottomI).get(j);
            if (tree >= bottomTree) score++;
            if (tree <= bottomTree) return score;
        }
        return score;
    }

    private Integer traverseLeft(int i, int j, List<List<Integer>> input) {
        Integer tree = input.get(i).get(j);
        Integer score = 0;
        for (int leftJ = j - 1; leftJ >= 0; leftJ--) {
            Integer leftTree = input.get(i).get(leftJ);
            if (tree >= leftTree) score++;
            if (tree <= leftTree) return score;
        }
        return score;
    }
}
