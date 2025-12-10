package lab3;

/**
 * Класс для хранения результата тестирования производительности коллекции.
 */
public class ListPerformanceResult {
    private final String listType;
    private final String method;
    private final int iterations;
    private final long timeMillis;

    /**
     * Конструктор результата.
     *
     * @param listType   Тип коллекции (ArrayList или LinkedList)
     * @param method     Название метода
     * @param iterations Количество итераций
     * @param timeMillis Время выполнения в миллисекундах
     */
    public ListPerformanceResult(String listType, String method, int iterations, long timeMillis) {
        this.listType = listType;
        this.method = method;
        this.iterations = iterations;
        this.timeMillis = timeMillis;
    }

    public String getListType() {
        return listType;
    }

    public String getMethod() {
        return method;
    }

    public int getIterations() {
        return iterations;
    }

    public long getTimeMillis() {
        return timeMillis;
    }
}
