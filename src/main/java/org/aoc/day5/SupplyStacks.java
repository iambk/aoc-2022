package org.aoc.day5;

import org.aoc.AOC;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SupplyStacks implements AOC<List<List<Integer>>, String> {
    private final List<Stack<Character>> stackList;

    public SupplyStacks(List<Stack<Character>> stackList) {
        this.stackList = stackList;
    }

    public static void main(String[] args) {
        SupplyStacks ss1 = new SupplyStacks(getStacks());
        SupplyStacks ss2 = new SupplyStacks(getStacks());

        // Process Input
        List<List<Integer>> input = ss1.processInput(AOC.getInput("src/main/resources/day5.txt"));

        // Part 1
        System.out.println(ss1.partOne(input));

        // Part 2
        System.out.println(ss2.partTwo(input));
    }

    @Override
    public List<List<Integer>> processInput(Stream<String> input) {
        return input.map(this::processMove)
                .toList();
    }

    @Override
    public String partOne(List<List<Integer>> input) {
        input.forEach(this::rearrangePartOne);
        return getTopOfEachStack();
    }

    @Override
    public String partTwo(List<List<Integer>> input) {
        input.forEach(this::rearrangePartTwo);
        return getTopOfEachStack();
    }

    public void rearrangePartOne(List<Integer> integers) {
        Integer elementsToMove = integers.get(0);
        Integer fromStackNumber = integers.get(1);
        Integer toStackNumber = integers.get(2);

        Stack<Character> fromStack = stackList.get(fromStackNumber - 1);
        Stack<Character> toStack = stackList.get(toStackNumber - 1);

        IntStream.range(0, elementsToMove)
                .forEach(turn -> toStack.push(fromStack.pop()));
    }

    public void rearrangePartTwo(List<Integer> integers) {
        Integer elementsToMove = integers.get(0);
        Integer fromStackNumber = integers.get(1);
        Integer toStackNumber = integers.get(2);

        Stack<Character> fromStack = stackList.get(fromStackNumber - 1);
        Stack<Character> toStack = stackList.get(toStackNumber - 1);

        Stack<Character> tempStack = new Stack<>();
        IntStream.range(0, elementsToMove)
                .forEach(turn -> tempStack.push(fromStack.pop()));
        IntStream.range(0, elementsToMove)
                .forEach(turn -> toStack.push(tempStack.pop()));
    }

    private String getTopOfEachStack() {
        return stackList.stream()
                .map(Stack::peek)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));

    }

    private List<Integer> processMove(String move) {
        return Arrays.stream(move.split("[a-z ]"))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Stack<Character>> getStacks() {
        String stack1 = "GFVHPS";
        String stack2 = "GJFBVDZM";
        String stack3 = "GMLJN";
        String stack4 = "NGZVDWP";
        String stack5 = "VRCB";
        String stack6 = "VRSMPWLZ";
        String stack7 = "THP";
        String stack8 = "QRSNCHZV";
        String stack9 = "FLGPVQJ";
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        Stack<Character> s3 = new Stack<>();
        Stack<Character> s4 = new Stack<>();
        Stack<Character> s5 = new Stack<>();
        Stack<Character> s6 = new Stack<>();
        Stack<Character> s7 = new Stack<>();
        Stack<Character> s8 = new Stack<>();
        Stack<Character> s9 = new Stack<>();
        s1.addAll(getCharacters(stack1));
        s2.addAll(getCharacters(stack2));
        s3.addAll(getCharacters(stack3));
        s4.addAll(getCharacters(stack4));
        s5.addAll(getCharacters(stack5));
        s6.addAll(getCharacters(stack6));
        s7.addAll(getCharacters(stack7));
        s8.addAll(getCharacters(stack8));
        s9.addAll(getCharacters(stack9));
        return List.of(s1, s2, s3, s4, s5, s6, s7, s8, s9);
    }

    private static List<Character> getCharacters(String stack) {
        return stack.chars()
                .mapToObj(ch -> (char) ch)
                .toList();
    }
}
