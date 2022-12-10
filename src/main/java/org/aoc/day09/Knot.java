package org.aoc.day09;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Knot {
    private final Knot tail;
    private Position position;

    public void moveUp() {
        this.position = this.position.up();
    }

    public void moveDown() {
        this.position = this.position.down();
    }

    public void moveLeft() {
        this.position = this.position.left();
    }

    public void moveRight() {
        this.position = this.position.right();
    }

    public void move(String direction) {
        switch (direction) {
            case "U" -> moveUp();
            case "D" -> moveDown();
            case "L" -> moveLeft();
            case "R" -> moveRight();
            case "UL" -> {
                moveUp();
                moveLeft();
            }
            case "UR" -> {
                moveUp();
                moveRight();
            }
            case "DL" -> {
                moveDown();
                moveLeft();
            }
            case "DR" -> {
                moveDown();
                moveRight();
            }
        }
    }

    public void pull() {
        if (Objects.isNull(tail)) return;
        if (tail.position.isFarAwayFrom(this.position)) {
            tail.move(tail.position.compareTo(this.position));
        }
    }
}
