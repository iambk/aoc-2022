package org.aoc.day4;

import org.aoc.utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CampCleanup {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> input = processInput("src/main/resources/day4.txt");

        // Part 1
        System.out.println(partOne(input));

        // Part 2
        System.out.println(partTwo(input));
    }

    public static List<List<Integer>> processInput(String pathToFile) throws IOException {
        List<String> input = FileReader.getLines(pathToFile).toList();

        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        for (String item : input) {
            String[] ids = item.split("[-,]");
            for (String id : ids) {
                pair.add(Integer.parseInt(id));
            }
            pairs.add(new ArrayList<>(pair));
            pair.clear();
        }
        return pairs;
    }

    public static int partOne(List<List<Integer>> input) {
        int total = 0;
        for (List<Integer> pair : input) {
            Integer p1 = pair.get(0);
            Integer p2 = pair.get(1);
            Integer p3 = pair.get(2);
            Integer p4 = pair.get(3);
            if (encompassesPartOne(p1, p2, p3, p4)) {
                total++;
            }
        }
        return total;
    }

    private static boolean encompassesPartOne(Integer p1, Integer p2, Integer p3, Integer p4) {
        if (p1 >= p3 && p1 <= p4 && p2 >= p3 && p2 <= p4) return true;
        return p3 >= p1 && p3 <= p2 && p4 >= p1 && p4 <= p2;
    }

    public static int partTwo(List<List<Integer>> input) {
        int total = 0;
        for (List<Integer> pair : input) {
            Integer p1 = pair.get(0);
            Integer p2 = pair.get(1);
            Integer p3 = pair.get(2);
            Integer p4 = pair.get(3);
            if (encompassesPartTwo(p1, p2, p3, p4)) {
                total++;
            }
        }
        return total;
    }

    private static boolean encompassesPartTwo(Integer p1, Integer p2, Integer p3, Integer p4) {
        if ((p1 >= p3 && p1 <= p4) || (p2 >= p3 && p2 <= p4)) return true;
        return ((p3 >= p1 && p3 <= p2) || (p4 >= p1 && p4 <= p2));
    }
}
