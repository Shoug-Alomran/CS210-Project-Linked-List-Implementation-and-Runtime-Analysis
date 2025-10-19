import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // Time reading operation
        System.out.println("Starting file reading...");
        timer.start();
        LinkedList registrations = InputValidator.readAndValidateFile("Input.txt");
        timer.stop(); // This timer times the file reading only
        System.out.println();
        System.out.println("File reading completed in: " + timer.getElapsedTimeMillis() + " ms");
        System.out.println("Successfully read " + registrations.size + " registrations.");
        System.out.println();

        // Time processing operation
        System.out.println("Starting demand score calculations...");
        timer.start();
        calculateAllDemandScores(registrations);
        timer.stop(); // This timer times the demand score calculations only
        System.out.println("Demand score calculations completed in: " + timer.getElapsedTimeMillis() + " ms");
        System.out.println();

        // Convert linked list to array
        Registration[] array = registrations.convToArray();

        // Time writing operation
        System.out.println("Writing unsorted data to file...");
        timer.start();
        FileService.writeRegistrationsToFile(array, "Output.txt");
        timer.stop(); // This timer times the file writing only
        System.out.println("File writing completed in: " + timer.getElapsedTimeMillis() + " ms");
        System.out.println("Saved unsorted data to Output.txt");
        System.out.println();

        // Run and time all sorting algorithms
        System.out.println("Starting sorting algorithms...");
        Benchmarker.runAllSorts(array);
        System.out.println("All sorting completed and results saved.");
        System.out.println();

        // Additional sorting using comparators (Not required but useful)
        System.out.println("\n--- ADDITIONAL COMPARATOR SORTING ---");

        // Sort by Student ID
        Registration[] idSorted = registrations.convToArray();
        Arrays.sort(idSorted, Comparators.by_ID);
        FileService.writeRegistrationsToFile(idSorted, "Sorted_By_ID.txt");
        System.out.println("Saved student ID sorted data to Sorted_By_ID.txt");

        // Sort by Course Code
        Registration[] courseSorted = registrations.convToArray();
        Arrays.sort(courseSorted, Comparators.by_CourseCode);
        FileService.writeRegistrationsToFile(courseSorted, "Sorted_By_Course.txt");
        System.out.println("Saved course code sorted data to Sorted_By_Course.txt");

        // Sort by Academic Level
        Registration[] levelSorted = registrations.convToArray();
        Arrays.sort(levelSorted, Comparators.by_Level);
        FileService.writeRegistrationsToFile(levelSorted, "Sorted_By_Level.txt");
        System.out.println("Saved academic level sorted data to Sorted_By_Level.txt");

        // Sort by Registration Time
        Registration[] timeSorted = registrations.convToArray();
        Arrays.sort(timeSorted, Comparators.by_RegTime);
        FileService.writeRegistrationsToFile(timeSorted, "Sorted_By_Time.txt");
        System.out.println("Saved registration time sorted data to Sorted_By_Time.txt");
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