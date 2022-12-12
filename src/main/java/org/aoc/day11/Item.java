package org.aoc.day11;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
    private long worryLevel;

    public void changeWorryLevel(String operator, long operand) {
        switch (operator) {
            case "*" -> worryLevel *= operand;
            case "+" -> worryLevel += operand;
        }
    }

    public void reduceWorryLevel(String strategy, long value) {
        switch (strategy) {
            case "divide" -> worryLevel /= value;
            case "mod" -> worryLevel %= value;
        }
    }
}
