package org.aoc.day7;

import org.aoc.AOC;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class NoSpace implements AOC<List<String>, Long> {
    public static void main(String[] args) throws IOException {
        NoSpace ns = new NoSpace();
        List<String> input = ns.processInput(AOC.getInput("src/main/resources/day7.txt"));

        createBashScript(input);

        // Part 1
        System.out.println(ns.partOne(input));

        // Part 2
        System.out.println(ns.partTwo(input));
    }

    @Override
    public List<String> processInput(Stream<String> input) {
        return input.map(NoSpace::transform)
                .filter(command -> !command.isBlank())
                .toList();
    }

    @Override
    public Long partOne(List<String> input) {
        try {
            //noinspection resource
            return Files.walk(Paths.get("src/main/resources/root"))
                    .map(NoSpace::getDirLength)
                    .filter(size -> size <= 100000L)
                    .mapToLong(Long::longValue)
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long partTwo(List<String> input) {
        Path root = Paths.get("src/main/resources/root");
        Long maxSpace = 70000000L;
        Long reqSpace = 30000000L;
        Long usedSpace = NoSpace.size(root);
        Long reqUnusedSpace = maxSpace - usedSpace;
        Long reqDeleteSpace = reqSpace - reqUnusedSpace;
        try {
            //noinspection resource,OptionalGetWithoutIsPresent
            return Files.walk(root)
                    .map(NoSpace::getDirLength)
                    .filter(size -> size >= reqDeleteSpace)
                    .mapToLong(Long::longValue)
                    .min()
                    .getAsLong();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createBashScript(List<String> input) throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/exec.sh");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        input.forEach(printWriter::println);
        printWriter.close();
    }

    public static Long getDirLength(Path path) {
        if (path.toFile().isDirectory()) {
            return size(path);
        }
        return Long.MAX_VALUE;
    }

    /**
     * Attempts to calculate the size of a file or directory.
     *
     * <p>
     * Since the operation is non-atomic, the returned value may be inaccurate.
     * However, this method is quick and does its best.
     */
    public static long size(Path path) {

        final AtomicLong size = new AtomicLong(0);

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

                    size.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {

                    System.out.println("skipped: " + file + " (" + exc + ")");
                    // Skip folders that can't be traversed
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {

                    if (exc != null)
                        System.out.println("had trouble traversing: " + dir + " (" + exc + ")");
                    // Ignore errors traversing a folder
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new AssertionError("walkFileTree will not throw IOException if the FileVisitor does not");
        }

        return size.get();
    }

    private static String transform(String command) {
        if (command.contains("ls")) return "";
        if (command.startsWith("$")) {
            return command.replace("$ ", "");
        } else if (command.startsWith("dir")) {
            return command.replace("dir", "mkdir");
        } else return "mkfile -n " + command;
    }
}
