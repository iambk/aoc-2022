package org.aoc.day09;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Head implements Knot {
    private int xPosition;
    private int yPosition;

    public Head() {
        this.xPosition = 0;
        this.yPosition = 0;
    }

    @Override
    public void moveUp() {
        this.xPosition--;
    }

    @Override
    public void moveDown() {
        this.xPosition++;
    }

    @Override
    public void moveLeft() {
        this.yPosition--;
    }

    @Override
    public void moveRight() {
        this.yPosition++;
    }
}
