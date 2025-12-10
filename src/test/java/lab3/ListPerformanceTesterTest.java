package lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Unit-тесты для класса ListPerformanceTester.
 */
public class ListPerformanceTesterTest {

    @Test
    public void testArrayListPerformance() {
        int iterations = 100;
        List<ListPerformanceResult> results =
                ListPerformanceTester.testListPerformance("ArrayList", new ArrayList<>(), iterations);

        assertEquals(6, results.size());
        for (ListPerformanceResult result : results) {
            assertEquals("ArrayList", result.getListType());
            assertEquals(iterations, result.getIterations());
            assertTrue(result.getTimeMillis() >= 0);
            assertNotNull(result.getMethod());
        }
    }

    @Test
    public void testLinkedListPerformance() {
        int iterations = 100;
        List<ListPerformanceResult> results =
                ListPerformanceTester.testListPerformance("LinkedList", new LinkedList<>(), iterations);

        assertEquals(6, results.size());
        for (ListPerformanceResult result : results) {
            assertEquals("LinkedList", result.getListType());
            assertEquals(iterations, result.getIterations());
            assertTrue(result.getTimeMillis() >= 0);
            assertNotNull(result.getMethod());
        }
    }

    @Test
    public void testPrintResultsTable() {
        List<ListPerformanceResult> results = new ArrayList<>();
        results.add(new ListPerformanceResult("ArrayList", "add", 10, 5));
        // Проверяем отсутствие исключений при выводе
        ListPerformanceTester.printResultsTable(results);
    }
}
