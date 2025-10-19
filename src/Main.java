public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        // Time reading operation
        System.out.println("Starting file reading...");
        timer.start();
        LinkedList registrations = InputValidator.readAndValidateFile("Input.txt");
        timer.stop();
        System.out.println("File reading completed in: " + timer.getElapsedTimeMillis() + " ms");
        System.out.println("Successfully read " + registrations.size + " registrations.");
        System.out.println();

        // Time processing operation
        System.out.println("Starting demand score calculations...");
        timer.start();
        calculateAllDemandScores(registrations);
        timer.stop();
        System.out.println("Demand score calculations completed in: " + timer.getElapsedTimeMillis() + " ms");
        System.out.println();

        // Convert linked list to array
        Registration[] array = registrations.convToArray();

        // Time writing operation
        System.out.println("Writing unsorted data to file...");
        timer.start();
        FileService.writeRegistrationsToFile(array, "Output.txt");
        timer.stop();
        System.out.println("File writing completed in: " + timer.getElapsedTimeMillis() + " ms");
        System.out.println("Saved unsorted data to Output.txt");
        System.out.println();

        // Run and time all sorting algorithms
        System.out.println("Starting sorting algorithms...");
        Benchmarker.runAllSorts(array);
        System.out.println("All sorting completed and results saved.");
    }

    // Calculate scores for all registrations
    public static void calculateAllDemandScores(LinkedList registrations) {
        Node current = registrations.head;
        while (current != null) {
            DemandScorer.computeDemandScore(current.studData);
            current = current.next;
        }
    }
}