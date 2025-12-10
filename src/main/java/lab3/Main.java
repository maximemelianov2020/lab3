package lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Главный класс для запуска сравнения производительности коллекций.
 */
public class Main {
    public static void main(String[] args) {
        int iterations = 2000;

        List<ListPerformanceResult> results = new ArrayList<>();
        results.addAll(ListPerformanceTester.testListPerformance("ArrayList", new ArrayList<>(), iterations));
        results.addAll(ListPerformanceTester.testListPerformance("LinkedList", new LinkedList<>(), iterations));

        ListPerformanceTester.printResultsTable(results);
    }
}
