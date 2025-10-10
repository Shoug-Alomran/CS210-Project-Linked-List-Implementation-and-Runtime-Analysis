public class SelectionSort implements Sorter {

    @Override
    public void sort(Registration[] array) {
        // Sort in DESCENDING order (highest demand scores first).
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i; // Assume the current position has the highest score.

            for (int j = i + 1; j < array.length; j++) { // Look at all remaining elements to find the actual highest.
                if (array[j].getStudDemandScore() > array[maxIndex].getStudDemandScore()) {
                    maxIndex = j; // Remember this as the new highest position.
                }
            }
            // Swap
            Registration temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    @Override
    public String name() {
        return "Selection Sort";
    }
}