public class Benchmarker {
    // Helper method to make a copy of the array
    private static Registration[] makeCopy(Registration[] original) {
        Registration[] copy = new Registration[original.length]; // Create new empty array
        for (int i = 0; i < original.length; i++) { // Loop through each element
            copy[i] = original[i]; // Copy each element
        }
        return copy; // Return the copy
    }

    // Runs all 4 sorting algorithms and times them.
    public static void runAllSorts(Registration[] originalArray) {
        System.out.println("--- RUNNING ALL SORTS ---");

        Timer timer = new Timer();

        // 1. SELECTION SORT
        Registration[] copy1 = makeCopy(originalArray); // Make fresh copy.
        timer.start(); // Start timer.
        new SelectionSort().sort(copy1); // Do the sorting + create an object.
        timer.stop(); // Stop timer
        // File writing moved OUTSIDE timed section to measure only sorting time
        FileService.writeRegistrationsToFile(copy1, "Sorted_Output_SS.txt"); // Save result.
        System.out.println("Selection Sort: " + timer.getElapsedTimeMillis() + " ms");

        // 2. INSERTION SORT
        Registration[] copy2 = makeCopy(originalArray); // Fresh copy again.
        timer.start();
        new InsertionSort().sort(copy2); // Do the sorting + create an object.
        timer.stop();
        // File writing moved OUTSIDE timed section to measure only sorting time
        FileService.writeRegistrationsToFile(copy2, "Sorted_Output_IS.txt"); // Save result.
        System.out.println("Insertion Sort: " + timer.getElapsedTimeMillis() + " ms");

        // 3. MERGE SORT
        Registration[] copy3 = makeCopy(originalArray); // Fresh copy again.
        timer.start();
        new MergeSort().sort(copy3); // Do the sorting.
        timer.stop();
        // File writing moved OUTSIDE timed section to measure only sorting time
        FileService.writeRegistrationsToFile(copy3, "Sorted_Output_MS.txt"); // Save result.
        System.out.println("Merge Sort: " + timer.getElapsedTimeMillis() + " ms");

        // 4. QUICK SORT
        Registration[] copy4 = makeCopy(originalArray); // Fresh copy again.
        timer.start();
        new QuickSort().sort(copy4); // Do the sorting + create an object.
        timer.stop();
        // File writing moved OUTSIDE timed section to measure only sorting time
        FileService.writeRegistrationsToFile(copy4, "Sorted_Output_QS.txt"); // Save result.
        System.out.println("Quick Sort: " + timer.getElapsedTimeMillis() + " ms");
    }
}