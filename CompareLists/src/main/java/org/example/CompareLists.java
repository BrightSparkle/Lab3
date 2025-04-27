package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompareLists {

    private static final int ITERATIONS = 10_000;

    public static void testPerformance() {
        System.out.println("Результаты сравнения производительности (нс):\n");
        System.out.println("| Метод   | Тип коллекции | Итераций | Время выполнения |");
        System.out.println("|---------|----------------|----------|------------------|");

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        testOperation("add", list1, ITERATIONS);
        testOperation("add", list2, ITERATIONS);

        testOperation("get", new ArrayList<>(), ITERATIONS);
        testOperation("get", new LinkedList<>(), ITERATIONS);

        testOperation("delete", list1, ITERATIONS);
        testOperation("delete", list2, ITERATIONS);
    }

    public static void testOperation(String operation, List<Integer> list, int iterations) {
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

    public static long testAdd(List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;
    }

    public static long testDelete(List<Integer> list, int iterations) {

        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.remove(0);
        }
        return System.nanoTime() - start;
    }

    public static long testGet(List<Integer> list, int iterations) {
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
