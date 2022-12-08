package org.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public interface AOC<T> {
    static List<String> getInput(String pathToFile) {
        try (Stream<String> input = Files.lines(Paths.get(pathToFile))) {
            return input.toList();
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot process input due to: " + ioException.getMessage());
        }
    }

    T partOne(List<String> input);

    T partTwo(List<String> input);
}
