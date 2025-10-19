public class Timer {
    // Private variables for safety, no other class can access these directly and effect the elapsed time.
    private long startTime;
    private long endTime;

    // Method to start timer
    public void start() {
        startTime = System.currentTimeMillis(); // Simpler than nanoTime
    }

    // Method to stop timer
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Method to get elapsed time in milliseconds
    public long getElapsedTimeMillis() {
        return endTime - startTime;
    }
}