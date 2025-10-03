public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public void printElapsedTime(String operation) {
        long duration = endTime - startTime;
        System.out.println(operation + " took " + duration + " ns");
    }
}
