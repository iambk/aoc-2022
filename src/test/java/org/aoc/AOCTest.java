package org.aoc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AOCTest {
    @Test
    void shouldReadFileWithSingleLine() {
        // Arrange
        String expectedLine = "Hello, World!";

        // Act
        List<String> lines = AOC.getInput("src/test/resources/fileWithSingleLine.txt");

        // Assert
        assertEquals(1, lines.size());
        assertEquals(expectedLine, lines.get(0));
    }

    @Test
    void shouldReadFileWithMultipleLines() {
        // Arrange
        String expectedLine1 = "line 1";
        String expectedLine2 = "";
        String expectedLine3 = "line 3";

        // Act
        List<String> lines = AOC.getInput("src/test/resources/fileWithMultipleLines.txt");

        // Assert
        assertEquals(3, lines.size());
        assertEquals(expectedLine1, lines.get(0));
        assertEquals(expectedLine2, lines.get(1));
        assertEquals(expectedLine3, lines.get(2));
    }
}
