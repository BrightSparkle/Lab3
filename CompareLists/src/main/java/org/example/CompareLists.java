package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompareLists {

    private static final int ITERATIONS = 10_000;

    private static void testOperation(String operation, List<Integer> list, int iterations) {
        String listType = list instanceof ArrayList ? "ArrayList" : "LinkedList";
        long time = 0;

        switch (operation) {
            case "add":
                time = testAdd(list, iterations);
                break;
            case "delete":
                time = testDelete(list, iterations);
                break;
            case "get":
                time = testGet(list, iterations);
                break;
        }

        System.out.printf("| %-7s | %-14s | %-8d | %-16d |\n",
                operation, listType, iterations, time);
    }

    private static long testAdd(List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;
    }

    private static long testDelete(List<Integer> list, int iterations) {
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.remove(0);
        }
        return System.nanoTime() - start;
    }

    private static long testGet(List<Integer> list, int iterations) {
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        int midIndex = iterations / 2;
        for (int i = 0; i < iterations; i++) {
            list.get(midIndex);
        }
        return System.nanoTime() - start;
    }
}
