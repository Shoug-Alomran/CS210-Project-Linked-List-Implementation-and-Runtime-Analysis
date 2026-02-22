# Asymptotic Complexity

This section evaluates the theoretical time complexity **T(n)**
and asymptotic growth rate **O(n)** for each phase of the system.

Asymptotic analysis allows us to predict how performance scales
as the dataset size increases.

---

## :material-file-sync-outline: File Reading & Writing

<div class="grid cards" markdown>

-   **Operation:** Reading from `Input.txt`  
-   **Operation:** Writing to `Output.txt`  
-   **Time Complexity:** O(n)

    Each record is processed exactly once.
    The total number of operations grows linearly
    with the number of registration records.

</div>

---

## :material-calculator-variant-outline: Demand Score Calculation

<div class="grid cards" markdown>

-   **Operation:** Compute demand score per registration  
-   **Time Complexity:** O(n)

    Each student record is evaluated once using
    constant-time arithmetic and conditional logic.
    No nested iteration is involved.

</div>

---

## :material-sort: Sorting Algorithms Complexity

| Algorithm | Best Case | Average Case | Worst Case | Explanation |
|------------|------------|---------------|--------------|--------------|
| Selection Sort | O(n²) | O(n²) | O(n²) | Repeatedly scans remaining unsorted elements to find minimum. |
| Insertion Sort | O(n) | O(n²) | O(n²) | Efficient for nearly sorted data; degrades with disorder. |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | Recursively divides array and merges efficiently. |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | Efficient with balanced pivots; worst case occurs with poor pivot choice. |

---

## :material-chart-line: Theoretical Insights

<div class="grid cards" markdown>

-   ### :material-expand-all-outline: Linear Phases

    File operations and demand score computation scale
    proportionally with input size (O(n)).

-   ### :material-trending-up: Divide-and-Conquer Efficiency

    Merge Sort and Quick Sort reduce the problem size recursively,
    achieving O(n log n) growth.

-   ### :material-alert-outline: Quadratic Growth

    Selection and Insertion Sort require nested iteration,
    resulting in O(n²) scaling for larger datasets.

</div>

---

## :material-check-decagram-outline: Summary

Theoretical analysis confirms that:

- **Merge Sort** and **Quick Sort** are optimal for large datasets.
- **Selection Sort** and **Insertion Sort** are simpler but inefficient at scale.
- Linear operations (file I/O and scoring) do not dominate runtime.

This theoretical framework directly explains the empirical
runtime measurements observed in the system.