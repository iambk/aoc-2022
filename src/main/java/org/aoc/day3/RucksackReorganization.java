package org.aoc.day3;

import org.aoc.utils.FileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RucksackReorganization {
    public static void main(String[] args) throws IOException {
        List<String> input = processInput("src/main/resources/day3.txt");

        // Part 1
        System.out.println(countPriorityPartOne(input));

        // Part 2
        System.out.println(countPriorityPartTwo(input));
    }

    public static List<String> processInput(String pathToFile) throws IOException {
        return FileReader.getLines(pathToFile).toList();
    }

    public static int countPriorityPartOne(List<String> input) {
        return input.stream()
                .map(s -> getPriorityValue(getPriorityItemPartOne(s)))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Character getPriorityItemPartOne(String input) {
        String part1 = input.substring(0, input.length() / 2);
        String part2 = input.substring(input.length() / 2);

        for (int i = 0; i < part1.length(); i++) {
            char c = part1.charAt(i);
            if (part2.indexOf(c) != -1) return c;
        }

        return null;
    }

    public static int countPriorityPartTwo(List<String> input) {
        int total = 0;
        for (int i = 0, j = 3; j <= input.size(); i += 3, j += 3) {
            total += getPriorityValue(getPriorityItemPartTwo(input.subList(i, j)));
        }
        return total;
    }

    public static Character getPriorityItemPartTwo(List<String> input) {
        String s1 = input.get(0);
        String s2 = input.get(1);
        String s3 = input.get(2);

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map3 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            if (!map1.containsKey(c)) map1.put(c, 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            Character c = s2.charAt(i);
            if (!map2.containsKey(c)) map2.put(c, 1);
        }
        for (int i = 0; i < s3.length(); i++) {
            Character c = s3.charAt(i);
            if (!map3.containsKey(c)) map3.put(c, 1);
        }

        return map1.keySet().stream()
                .filter(key -> (map2.containsKey(key) && map3.containsKey(key)))
                .findFirst()
                .get();
    }

    public static int getPriorityValue(Character input) {
        if (Character.isLowerCase(input)) return input - 96;
        else return input - 38;
    }
}
