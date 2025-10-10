public class Main {
    public static void main(String[] args) {
        // Task: Read input file using FileService
        // Task: Build LinkedList with Registration data
        // Task: Write unsorted Output.txt
        // Task: Run SelectionSort, InsertionSort, MergeSort, QuickSort
        // Task: Time each sort and save results to files
        // Task: Print timing summary to console

        // Use your validator to read and validate file
        LinkedList registrations = InputValidator.readAndValidateFile("Input.txt");

        // Calculate demand scores for all registrations
        calculateAllDemandScores(registrations);

        // Convert LinkedList to array
        Registration[] array = registrations.convToArray();
    }

    // Method to calculate demand scores for all registrations in the linked list
    public static void calculateAllDemandScores(LinkedList registrations) {
        // Loop through all registrations and compute their scores
        // Traverse linked list
    }
}
