package org.aoc.day10;

import org.aoc.AOC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CathodeRayTube implements AOC<List<Integer>, Integer> {
    public static void main(String[] args) {
        CathodeRayTube crt = new CathodeRayTube();

        // Process input
        List<Integer> registerValues = crt.processInput(AOC.getInput("src/main/resources/day10.txt"));

        // Part 1
        System.out.println(crt.partOne(registerValues));

        // Part 2
        System.out.println(crt.partTwo(registerValues));
    }

    @Override
    public List<Integer> processInput(Stream<String> input) {
        List<String> commands = input.toList();
        List<Integer> registerValues = new ArrayList<>();
        int registerX = 1;
        registerValues.add(registerX);
        for (String s : commands) {
            registerValues.add(registerX);
            String[] command = s.split(" ");
            String operation = command[0];
            if ("addx".equals(operation)) {
                registerX += Integer.parseInt(command[1]);
                registerValues.add(registerX);
            }
        }
        return registerValues;
    }

    @Override
    public Integer partOne(List<Integer> registerValues) {
        return IntStream.rangeClosed(20, 220)
                .filter(idx -> idx % 40 == 20)
                .reduce(0, (strength, idx) -> strength + (idx * registerValues.get(idx - 1)));
    }

    @Override
    public Integer partTwo(List<Integer> registerValues) {
        int cycle = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 40; j++) {
                Integer registerValue = registerValues.get(cycle);
                if (registerValue - 1 == j || registerValue == j || registerValue + 1 == j) System.out.print('#');
                else System.out.print(' ');
                cycle++;
            }
            System.out.println();
        }
        return null;
    }
}
