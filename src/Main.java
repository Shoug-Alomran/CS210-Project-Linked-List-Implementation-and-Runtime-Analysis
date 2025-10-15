public class Main {
    public static void main(String[] args) {
        // Read and validate input file.
        // Use InputValidator to read file and build linked list of valid registrations.
        LinkedList registrations = InputValidator.readAndValidateFile("Input.txt");
        System.out.println();
        System.out.println("Successfully read " + registrations.size + " registrations.");

        // Calculate all demand scores.
        // Process each registration to compute their demand scores.
        calculateAllDemandScores(registrations);
        System.out.println("Completed demand score calculations.");

        // Layan's part: convert linked list to array.
        // Layan use convToArray method to prepare for sorting.
        Registration[] array = registrations.convToArray();

        // Write unsorted output.
        // Save the unsorted data with calculated scores to Output.txt.
        FileService.writeRegistrationsToFile(array, "Output.txt");
        System.out.println("Saved unsorted data to Output.txt");

        // Run and time all sorting algorithms.
        // Use Benchmarker to time each sort and save sorted results.
        System.out.println("Starting sorting algorithms...");
        Benchmarker.runAllSorts(array);
        System.out.println("All sorting completed and results saved.");
    }

    // Calculate scores for all registrations.
    // Traverse Layan's linked list and apply demand scoring to each node.
    public static void calculateAllDemandScores(LinkedList registrations) {
        Node current = registrations.head; // Start at first node in Layan's list.
        while (current != null) { // Loop until end of list.
            DemandScorer.computeDemandScore(current.studData); // Calculate score using my DemandScorer.
            current = current.next; // Move to next node in Layan's list.
        }
    }
}