package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для сравнения производительности ArrayList и LinkedList.
 * <p>
 * Содержит методы тестирования основных операций коллекций: добавление, удаление, доступ к элементам.
 * Результаты выводятся в виде таблицы с временем выполнения в наносекундах.
 * </p>
 */
public class CompareLists {

    /**
     * Количество итераций для тестирования каждой операции
     */
    private static final int ITERATIONS = 10_000;

    /**
     * Запускает все тесты производительности и выводит результаты
     */
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

    /**
     * Выполняет тестирование указанной операции
     * @param operation название операции (add/delete/get)
     * @param list тестируемая коллекция
     * @param iterations количество итераций
     */
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

    /**
     * Тестирует операцию добавления элементов
     * @param list коллекция для тестирования
     * @param iterations количество элементов для добавления
     * @return время выполнения в наносекундах
     */
    public static long testAdd(List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;
    }

    /**
     * Тестирует операцию удаления элементов
     * @param list коллекция для тестирования
     * @param iterations количество элементов для удаления
     * @return время выполнения в наносекундах
     */
    public static long testDelete(List<Integer> list, int iterations) {

        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.remove(0);
        }
        return System.nanoTime() - start;
    }

    /**
     * Тестирует операцию доступа к элементам
     * @param list коллекция для тестирования
     * @param iterations количество обращений
     * @return время выполнения в наносекундах
     */
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
