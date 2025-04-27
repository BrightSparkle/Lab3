package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompareLists {

    private static final int ITERATIONS = 10_000;

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
