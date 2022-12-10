package org.aoc.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KnotTest {
    @Test
    void shouldNotThrowError() {
        // Arrange
        Position defaultPosition = new Position(0, 0);
        Knot tail = new Knot(null, defaultPosition);

        assertDoesNotThrow(tail::pull);
    }

    @Test
    void shouldNotRealignIfNotNecessary() {
        // Arrange
        Position expectedPosition = new Position(1, 2);
        Knot tail = new Knot(null, expectedPosition);
        Knot head = new Knot(tail, expectedPosition);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }

    @Test
    void shouldRealignToLeft() {
        // Arrange
        Knot tail = new Knot(null, new Position(0, 4));
        Knot head = new Knot(tail, new Position(0, 2));
        Position expectedPosition = new Position(0, 3);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }

    @Test
    void shouldRealignToRight() {
        // Arrange
        Knot tail = new Knot(null, new Position(0, 2));
        Knot head = new Knot(tail, new Position(0, 4));
        Position expectedPosition = new Position(0, 3);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }

    @Test
    void shouldRealignDownwards() {
        // Arrange
        Knot tail = new Knot(null, new Position(0, 4));
        Knot head = new Knot(tail, new Position(2, 4));
        Position expectedPosition = new Position(1, 4);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }

    @Test
    void shouldRealignUpwards() {
        // Arrange
        Knot tail = new Knot(null, new Position(2, 4));
        Knot head = new Knot(tail, new Position(0, 4));
        Position expectedPosition = new Position(1, 4);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }

    @Test
    void shouldRealignDiagonallyUpAndLeft() {
        // Arrange
        Knot tail = new Knot(null, new Position(2, 2));
        Knot head = new Knot(tail, new Position(0, 1));
        Position expectedPosition = new Position(1, 1);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }

    @Test
    void shouldRealignDiagonallyUpAndRight() {
        // Arrange
        Knot tail = new Knot(null, new Position(2, 2));
        Knot head = new Knot(tail, new Position(0, 3));
        Position expectedPosition = new Position(1, 3);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }

    @Test
    void shouldRealignDiagonallyDownAndLeft() {
        // Arrange
        Knot tail = new Knot(null, new Position(2, 2));
        Knot head = new Knot(tail, new Position(4, 1));
        Position expectedPosition = new Position(3, 1);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());

    }

    @Test
    void shouldRealignDiagonallyDownAndRight() {
        // Arrange
        Knot tail = new Knot(null, new Position(2, 2));
        Knot head = new Knot(tail, new Position(4, 3));
        Position expectedPosition = new Position(3, 3);

        // Act
        head.pull();

        // Assert
        assertEquals(expectedPosition, tail.getPosition());
    }
}
