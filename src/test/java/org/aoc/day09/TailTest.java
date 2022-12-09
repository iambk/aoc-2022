package org.aoc.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TailTest {
    @Test
    void shouldNotRealignIfNotNecessary() {
        // Arrange
        Head head = new Head(1, 2);
        Tail tail = new Tail(head, 1, 2);

        // Act
        tail.realign();

        // Assert
        assertEquals(1, tail.getXPosition());
        assertEquals(2, tail.getYPosition());
    }

    @Test
    void shouldRealignToLeft() {
        // Arrange
        Head head = new Head(0, 2);
        Tail tail = new Tail(head, 0, 4);

        // Act
        tail.realign();

        // Assert
        assertEquals(0, tail.getXPosition());
        assertEquals(3, tail.getYPosition());
    }

    @Test
    void shouldRealignToRight() {
        // Arrange
        Head head = new Head(0, 4);
        Tail tail = new Tail(head, 0, 2);

        // Act
        tail.realign();

        // Assert
        assertEquals(0, tail.getXPosition());
        assertEquals(3, tail.getYPosition());
    }

    @Test
    void shouldRealignDownwards() {
        // Arrange
        Head head = new Head(2, 4);
        Tail tail = new Tail(head, 0, 4);

        // Act
        tail.realign();

        // Assert
        assertEquals(1, tail.getXPosition());
        assertEquals(4, tail.getYPosition());
    }

    @Test
    void shouldRealignUpwards() {
        // Arrange
        Head head = new Head(0, 4);
        Tail tail = new Tail(head, 2, 4);

        // Act
        tail.realign();

        // Assert
        assertEquals(1, tail.getXPosition());
        assertEquals(4, tail.getYPosition());
    }

    @Test
    void shouldRealignDiagonallyUpAndLeft() {
        // Arrange
        Head head = new Head(0, 1);
        Tail tail = new Tail(head, 2, 2);

        // Act
        tail.realign();

        // Assert
        assertEquals(1, tail.getXPosition());
        assertEquals(1, tail.getYPosition());
    }

    @Test
    void shouldRealignDiagonallyUpAndRight() {
        // Arrange
        Head head = new Head(0, 3);
        Tail tail = new Tail(head, 2, 2);

        // Act
        tail.realign();

        // Assert
        assertEquals(1, tail.getXPosition());
        assertEquals(3, tail.getYPosition());
    }

    @Test
    void shouldRealignDiagonallyDownAndLeft() {
        // Arrange
        Head head = new Head(4, 1);
        Tail tail = new Tail(head, 2, 2);

        // Act
        tail.realign();

        // Assert
        assertEquals(3, tail.getXPosition());
        assertEquals(1, tail.getYPosition());
    }

    @Test
    void shouldRealignDiagonallyDownAndRight() {
        // Arrange
        Head head = new Head(4, 3);
        Tail tail = new Tail(head, 2, 2);

        // Act
        tail.realign();

        // Assert
        assertEquals(3, tail.getXPosition());
        assertEquals(3, tail.getYPosition());
    }
}
