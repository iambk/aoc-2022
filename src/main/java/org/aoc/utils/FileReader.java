package org.aoc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    private FileReader() {
    }

    public static Stream<String> getLines(String pathToFile) throws IOException {
        return Files.lines(Paths.get(pathToFile));
    }
}
