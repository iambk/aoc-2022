package org.aoc.day9;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tail implements Knot {
    private final Knot head;
    private int xPosition;
    private int yPosition;

    public Tail(Knot head) {
        this.head = head;
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

    public void realign() {
        if (requiresRealignment()) {
            int headXPosition = head.getXPosition();
            int headYPosition = head.getYPosition();
            int xPosition = this.getXPosition();
            int yPosition = this.getYPosition();
            if (xPosition == headXPosition) {
                if (yPosition > headYPosition) this.moveLeft();
                else this.moveRight();
            } else if (yPosition == headYPosition) {
                if (xPosition > headXPosition) this.moveUp();
                else this.moveDown();
            } else if (xPosition < headXPosition) {
                this.moveDown();
                if (yPosition > headYPosition) this.moveLeft();
                else this.moveRight();
            } else {
                this.moveUp();
                if (yPosition > headYPosition) this.moveLeft();
                else this.moveRight();
            }
        }
    }

    private boolean requiresRealignment() {
        return Math.abs(head.getXPosition() - this.getXPosition()) == 2
                || Math.abs(head.getYPosition() - this.getYPosition()) == 2;
    }
}
