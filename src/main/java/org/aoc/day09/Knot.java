package org.aoc.day09;

public interface Knot {
    int getXPosition();

    int getYPosition();

    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    default void move(String direction) {
        switch (direction) {
            case "U" -> moveUp();
            case "D" -> moveDown();
            case "R" -> moveRight();
            case "L" -> moveLeft();
        }
    }
}
