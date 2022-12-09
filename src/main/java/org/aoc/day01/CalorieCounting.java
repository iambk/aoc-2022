package org.aoc.day01;

import org.aoc.AOC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalorieCounting implements AOC<List<List<Integer>>, Integer> {
    public static void main(String[] args) {
        CalorieCounting cc = new CalorieCounting();

        // Process input
        List<List<Integer>> input = cc.processInput(AOC.getInput("src/main/resources/day1.txt"));

        // Part 1
        System.out.println(cc.partOne(input));

        // Part 2
        System.out.println(cc.partTwo(input));
    }

    @Override
    public List<List<Integer>> processInput(Stream<String> input) {
        List<List<Integer>> allElfFoodCalories = new ArrayList<>();
        List<Integer> individualElfFoodCalories = new ArrayList<>();
        input.forEach(item -> {
            if (item.length() > 0) {
                individualElfFoodCalories.add(Integer.parseInt(item));
            } else {
                allElfFoodCalories.add(new ArrayList<>(individualElfFoodCalories));
                individualElfFoodCalories.clear();
            }
        });
        allElfFoodCalories.add(individualElfFoodCalories);
        return allElfFoodCalories;
    }

    @Override
    public Integer partOne(List<List<Integer>> input) {
        return Collections.max(countCalories(input));
    }

    @Override
    public Integer partTwo(List<List<Integer>> input) {
        List<Integer> calories = countCalories(input);
        Collections.sort(calories);
        return calories.subList(calories.size() - 3, calories.size())
                .stream()
                .reduce(0, Integer::sum);
    }

    private static List<Integer> countCalories(List<List<Integer>> input) {
        return input.stream()
                .map(foodList -> foodList.stream().reduce(0, Integer::sum))
                .collect(Collectors.toList());
    }
}
