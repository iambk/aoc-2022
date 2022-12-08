package org.aoc.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {
    @Test
    void shouldReadFileWithSingleLine() throws IOException {
        // Arrange
        String expectedLine = "Hello, World!";

        // Act
        List<String> lines = FileReader.getLines("src/test/resources/fileWithSingleLine.txt").toList();

        // Assert
        assertEquals(1, lines.size());
        assertEquals("Hello, World!", lines.get(0));
    }

    @Test
    void shouldReadFileWithMultipleLines() throws IOException {
        // Arrange
        String expectedLine1 = "line 1";
        String expectedLine2 = "";
        String expectedLine3 = "line 3";

        // Act
        List<String> lines = FileReader.getLines("src/test/resources/fileWithMultipleLines.txt").toList();

        // Assert
        assertEquals(3, lines.size());
        assertEquals("line 1", lines.get(0));
        assertEquals("", lines.get(1));
        assertEquals("line 3", lines.get(2));
    }
}