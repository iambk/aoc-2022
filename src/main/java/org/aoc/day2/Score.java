package org.aoc.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Score {
    X(1),
    Y(2),
    Z(3),
    LOSE(0),
    DRAW(3),
    WIN(6);

    private final int score;
}
