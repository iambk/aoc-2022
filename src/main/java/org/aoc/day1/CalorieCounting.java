package org.aoc.day1;

import org.aoc.utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    public static List<Integer> countCalories(List<List<Integer>> input) {
        List<Integer> elfCalorieList = new ArrayList<>();
        for (List<Integer> individualElfFoodList : input) {
            int sum = individualElfFoodList.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            elfCalorieList.add(sum);
        }
        return elfCalorieList;
    }

    public static List<List<Integer>> processInput(String pathToFile) throws IOException {
        List<String> input = FileReader.getLines(pathToFile).toList();

        List<List<Integer>> allElfFoodCalories = new ArrayList<>();
        List<Integer> individualElfFoodCalories = new ArrayList<>();
        for (String item : input) {
            if (item.length() > 0) {
                individualElfFoodCalories.add(Integer.parseInt(item));
            }
            else {
                allElfFoodCalories.add(new ArrayList<>(individualElfFoodCalories));
                individualElfFoodCalories.clear();
            }
        }
        allElfFoodCalories.add(individualElfFoodCalories);
        return allElfFoodCalories;
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> input = processInput("src/main/resources/day1.txt");
        List<Integer> elfCalorieList = countCalories(input);

        // Part 1
        System.out.println(Collections.max(elfCalorieList));

        // Part 2
        Collections.sort(elfCalorieList);
        Integer max1 = elfCalorieList.get(elfCalorieList.size() - 1);
        Integer max2 = elfCalorieList.get(elfCalorieList.size() - 2);
        Integer max3 = elfCalorieList.get(elfCalorieList.size() - 3);
        System.out.println(max1 + max2 + max3);
    }
}
