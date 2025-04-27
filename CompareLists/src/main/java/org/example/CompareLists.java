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
}
