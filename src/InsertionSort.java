public class InsertionSort implements Sorter {

    @Override
    public void sort(Registration[] array) {
        // Start from the second element (index 1).
        for (int i = 1; i < array.length; i++) {
            Registration current = array[i];
            double currentScore = current.getStudDemandScore(); // Get the demand score of the current element for
                                                                // comparison.
            int j = i - 1; // Start comparing with the element immediately to the left.

            // Shift elements that are smaller than current to the right.
            while (j >= 0 && array[j].getStudDemandScore() < currentScore) {
                array[j + 1] = array[j]; // Shift element to the right.
                j--;
            }
            // Insert current element in correct position.
            array[j + 1] = current;
        }
    }

    @Override
    public String name() {
        return "Insertion Sort";
    }
}
