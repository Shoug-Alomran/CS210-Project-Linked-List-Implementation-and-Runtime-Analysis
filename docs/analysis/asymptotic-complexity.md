# Asymptotic Complexity

This section analyzes the theoretical time complexity **T(n)** and Big-O **O(n)** for each phase and sorting algorithm used in the system.

---

## File Reading and Writing
- **Operation:** Reading from `Input.txt` and writing to `Output.txt`
- **Complexity:** O(n)
- **Explanation:** Each record is read and written once, so execution grows linearly with the number of records.

---

## Demand Score Calculation
- **Operation:** Calculating demand score for each student
- **Complexity:** O(n)
- **Explanation:** Each record is processed once with simple arithmetic operations and conditional checks.

---

## Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Explanation |
|------------|------------|---------------|--------------|--------------|
| Selection Sort | O(n²) | O(n²) | O(n²) | Always scans the unsorted part of the array for the minimum element. |
| Insertion Sort | O(n) | O(n²) | O(n²) | Performs best when data is nearly sorted. |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | Divides the array into halves recursively, merging sorted parts efficiently. |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | Fastest in most cases but degrades if pivots are poorly chosen. |

---

## Summary

Theoretical performance confirms that:
- **Merge Sort** and **Quick Sort** are the most efficient for large datasets.
- **Selection Sort** and **Insertion Sort** are simpler but slower, suitable for small datasets or educational use.