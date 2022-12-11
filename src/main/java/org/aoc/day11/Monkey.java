package org.aoc.day11;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class Monkey {
    private List<Long> items;
    private String operator;
    private String operationValue;
    private Integer divisibilityTest;
    private Integer truthMonkey;
    private Integer falseMonkey;
    private Long inspects;

    public int getItemsSize() {
        return items.size();
    }

    public Long getItem(int idx) {
        return items.get(idx);
    }

    public void catchItem(Long item) {
        items.add(item);
    }

    public void clearItems() {
        items.clear();
    }

    public Integer getDivisibilityTest() {
        return divisibilityTest;
    }

    public Long getInspects() {
        return inspects;
    }

    public void inspect(int idx, long mod) {
        operateWithMod(idx, mod);
        inspects++;
    }

    public void operateWithMod(int idx, long mod) {
        Long item = items.get(idx);
        Long value;
        if ("old".equals(operationValue)) value = item;
        else value = Long.parseLong(operationValue);
        switch (operator) {
            case "*" -> items.set(idx, modularMultiplication(item, value, mod));
            case "+" -> items.set(idx, modularAddition(item, value, mod));
        }
    }

    public void reduceWorry(int idx) {
        items.set(idx, items.get(idx) / 3L);
    }

    public int test(int idx) {
        if (items.get(idx) % divisibilityTest == 0) return truthMonkey;
        else return falseMonkey;
    }

    private Long modularMultiplication(long op1, long op2, long mod) {
        return ((op1 % mod) * (op2 % mod)) % mod;
    }

    private Long modularAddition(long op1, long op2, long mod) {
        return ((op1 % mod) + (op2 % mod)) % mod;
    }
}
