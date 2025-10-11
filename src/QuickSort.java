public class QuickSort implements Sorter {

    @Override
    public void sort(Registration[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Registration[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index.
            int pivotIndex = partition(array, low, high);

            // Recursively sort elements before and after pivot.
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(Registration[] array, int low, int high) {
        // Choose the rightmost element as pivot.
        double pivot = array[high].getStudDemandScore();
        int i = low - 1; // Index of smaller element.

        for (int j = low; j < high; j++) {
            // If current element is greater than or equal to pivot (descending order).
            if (array[j].getStudDemandScore() >= pivot) {
                i++;
                // Swap array[i] and array[j]
                Registration temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (put pivot in correct position).
        Registration temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    @Override
    public String name() {
        return "Quick Sort";
    }
}