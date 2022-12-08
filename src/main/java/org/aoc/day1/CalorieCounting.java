package org.aoc.day1;

import org.aoc.utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    public static List<Integer> countMaxCalories(String file) throws IOException {
        List<String> itemCollection = FileReader.getLines(file).toList();

        int maxCalories = 0, calories = 0;
        List<Integer> totalCalories = new ArrayList<>();
        for (String item : itemCollection) {
            if (item.length() > 0) {
                calories += Integer.parseInt(item);
            } else {
                if (calories > maxCalories) maxCalories = calories;
                totalCalories.add(calories);
                calories = 0;
            }
        }

        Collections.sort(totalCalories);
        return totalCalories;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> totalCalories = CalorieCounting.countMaxCalories("src/main/resources/day1.txt");
        Integer max1 = totalCalories.get(totalCalories.size() - 1);
        Integer max2 = totalCalories.get(totalCalories.size() - 2);
        Integer max3 = totalCalories.get(totalCalories.size() - 3);
        System.out.println(max1);
        System.out.println(max1 + max2 + max3);
    }
}
