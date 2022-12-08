package org.aoc.day1;

import org.aoc.AOC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalorieCounting implements AOC<Integer> {
    public static void main(String[] args) {
        List<String> input = AOC.getInput("src/main/resources/day1.txt");
        CalorieCounting cc = new CalorieCounting();

        // Part 1
        System.out.println(cc.partOne(input));

        // Part 2
        System.out.println(cc.partTwo(input));
    }

    @Override
    public Integer partOne(List<String> input) {
        return Collections.max(countCalories(processInput(input)));
    }

    @Override
    public Integer partTwo(List<String> input) {
        List<Integer> calories = countCalories(processInput(input));
        Collections.sort(calories);
        return calories.subList(calories.size() - 3, calories.size())
                .stream()
                .reduce(0, Integer::sum);
    }

    public List<List<Integer>> processInput(List<String> input) {
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

    private static List<Integer> countCalories(List<List<Integer>> input) {
        return input.stream()
                .map(foodList -> foodList.stream().reduce(0, Integer::sum))
                .collect(Collectors.toList());
    }
}
