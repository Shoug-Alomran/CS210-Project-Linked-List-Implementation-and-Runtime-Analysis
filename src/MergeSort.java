public class MergeSort implements Sorter {

    @Override
    public void sort(Registration[] array) {
        if (array.length < 2) {
            return; // Base case: arrays of size 0 or 1 are already sorted
        }

        // Split the array into two halves.
        int mid = array.length / 2;
        Registration[] left = new Registration[mid];
        Registration[] right = new Registration[array.length - mid];

        // Copy first half of original array into left array.
        for (int i = 0; i < mid; i++) {
            left[i] = array[i]; // Copy elements from start to mid-1.
        }

        // Copy second half of original array into right array.
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i]; // Copy elements from mid to end.
            // i-mid converts the index (ex. if mid = 2, i = 2 becomes right[0]).
        }

        // Recursively sort both halves.
        sort(left);
        sort(right);

        // Merge the sorted halves back together.
        merge(array, left, right);
    }

    private void merge(Registration[] result, Registration[] left, Registration[] right) {
        // Three pointers:
        int i = 0; // Tracks position in left array
        int j = 0; // Tracks position in right array
        int k = 0; // Tracks position in result array

        // Compare elements from left and right arrays, take the larger one (descending
        // order).
        while (i < left.length && j < right.length) {
            if (left[i].getStudDemandScore() >= right[j].getStudDemandScore()) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        // Copy any remaining elements from left array.
        while (i < left.length) {
            result[k++] = left[i++];
        }
        // Copy any remaining elements from right array.
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    @Override
    public String name() {
        return "Merge Sort";
    }
}