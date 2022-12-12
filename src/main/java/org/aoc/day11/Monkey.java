package org.aoc.day11;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

@AllArgsConstructor
public class Monkey {
    private Queue<Item> items;
    private String operator;
    private String operand;
    private int divisibilityTestNumber;
    private int truthMonkey;
    private int falseMonkey;
    private long inspects;

    public boolean hasItems() {
        return items.size() > 0;
    }

    public Item peekItem() {
        return items.peek();
    }

    public Item throwItem() {
        return items.remove();
    }

    public void catchItem(Item item) {
        items.add(item);
    }

    public Integer getDivisibilityTestNumber() {
        return divisibilityTestNumber;
    }

    public Long getInspects() {
        return inspects;
    }

    public void inspect() {
        operate();
        inspects++;
    }

    private void operate() {
        long value = ("old".equals(operand)) ? this.peekItem().getWorryLevel() : Long.parseLong(operand);
        this.peekItem().changeWorryLevel(operator, value);
    }

    public int testDivisibility() {
        if (this.peekItem().getWorryLevel() % divisibilityTestNumber == 0) return truthMonkey;
        else return falseMonkey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monkey monkey = (Monkey) o;
        return divisibilityTestNumber == monkey.divisibilityTestNumber
                && truthMonkey == monkey.truthMonkey
                && falseMonkey == monkey.falseMonkey
                && inspects == monkey.inspects
                && Arrays.equals(items.toArray(), monkey.items.toArray())
                && operator.equals(monkey.operator)
                && operand.equals(monkey.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, operator, operand, divisibilityTestNumber, truthMonkey, falseMonkey, inspects);
    }
}
