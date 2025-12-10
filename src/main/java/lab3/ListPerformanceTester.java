package lab3;

import java.util.*;

/**
 * Класс для сравнения производительности ArrayList и LinkedList.
 */
public class ListPerformanceTester {

    /**
     * Тестирует производительность основных методов коллекций.
     *
     * @param listType   Название типа коллекции
     * @param list       Коллекция для тестирования
     * @param iterations Количество итераций
     * @return Список результатов тестирования
     */
    public static List<ListPerformanceResult> testListPerformance(String listType, List<Integer> list, int iterations) {
        List<ListPerformanceResult> results = new ArrayList<>();

        // add (в конец)
        list.clear();
        long startAdd = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        long endAdd = System.nanoTime();
        results.add(new ListPerformanceResult(listType, "add", iterations, (endAdd - startAdd) / 1_000_000));

        // get (по индексу)
        long startGet = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.get(i);
        }
        long endGet = System.nanoTime();
        results.add(new ListPerformanceResult(listType, "get", iterations, (endGet - startGet) / 1_000_000));

        // contains
        long startContains = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.contains(i);
        }
        long endContains = System.nanoTime();
        results.add(new ListPerformanceResult(listType, "contains", iterations, (endContains - startContains) / 1_000_000));

        // add в начало
        list.clear();
        long startAddFirst = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(0, i);
        }
        long endAddFirst = System.nanoTime();
        results.add(new ListPerformanceResult(listType, "add at index 0", iterations, (endAddFirst - startAddFirst) / 1_000_000));

        // remove с конца
        list.clear();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        long startRemoveEnd = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.remove(list.size() - 1);
        }
        long endRemoveEnd = System.nanoTime();
        results.add(new ListPerformanceResult(listType, "remove from end", iterations, (endRemoveEnd - startRemoveEnd) / 1_000_000));

        // remove с начала
        list.clear();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        long startRemoveStart = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.remove(0);
        }
        long endRemoveStart = System.nanoTime();
        results.add(new ListPerformanceResult(listType, "remove from start", iterations, (endRemoveStart - startRemoveStart) / 1_000_000));

        return results;
    }

    /**
     * Выводит результаты в виде таблицы.
     *
     * @param allResults Список всех результатов
     */
    public static void printResultsTable(List<ListPerformanceResult> allResults) {
        System.out.printf("%-12s | %-18s | %-10s | %-10s%n", "List Type", "Method", "Iterations", "Time (ms)");
        System.out.println("-------------------------------------------------------------------");
        for (ListPerformanceResult r : allResults) {
            System.out.printf("%-12s | %-18s | %-10d | %-10d%n",
                    r.getListType(), r.getMethod(), r.getIterations(), r.getTimeMillis());
        }
    }
}
