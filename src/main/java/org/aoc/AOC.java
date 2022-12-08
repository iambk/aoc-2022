package org.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public interface AOC<I, O> {
    static Stream<String> getInput(String pathToFile) {
        try {
            return Files.lines(Paths.get(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    I processInput(Stream<String> input);

    O partOne(I input);

    O partTwo(I input);
}
