package org.aoc.day06;

import org.aoc.AOC;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TuningTrouble implements AOC<String, Integer> {
    private static final int PART_ONE_PACKET_SIZE = 4;
    private static final int PART_TWO_PACKET_SIZE = 14;

    public static void main(String[] args) {
        TuningTrouble tt = new TuningTrouble();

        // Process input
        String input = tt.processInput(AOC.getInput("src/main/resources/day6.txt"));

        // Part 1
        System.out.println(tt.partOne(input));

        // Part 2
        System.out.println(tt.partTwo(input));
    }

    @Override
    public String processInput(Stream<String> input) {
        return input.toList().get(0);
    }

    @Override
    public Integer partOne(String input) {
        return findStartOfPacket(input, PART_ONE_PACKET_SIZE);
    }

    @Override
    public Integer partTwo(String input) {
        return findStartOfPacket(input, PART_TWO_PACKET_SIZE);
    }

    private static int findStartOfPacket(String input, int packetSize) {
        for (int i = 0; i < input.length() - packetSize; i++) {
            int uniqueChars = input.substring(i, i + packetSize)
                    .chars()
                    .mapToObj(ch -> (char) ch)
                    .collect(Collectors.toSet())
                    .size();
            if (uniqueChars == packetSize) return i + packetSize;
        }
        return 0;
    }
}
