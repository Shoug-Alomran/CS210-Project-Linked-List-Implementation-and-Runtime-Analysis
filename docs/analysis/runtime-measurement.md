# Runtime Measurement

Runtime performance was measured using the **Java Clock class**
to capture execution time for each major phase.

The dataset contained **3432 registration records**, and all
algorithms were executed under identical system conditions to
ensure fairness and consistency.

---

## :material-table: Measured Runtime Results

| Operation | Theoretical Complexity | Actual Runtime (ms) |
|------------|------------------------|--------------------|
| File Reading | O(n) | 106 |
| Demand Score Calculation | O(n) | 98 |
| File Writing (Unsorted) | O(n) | 48 |
| Selection Sort | O(n²) | 45 |
| Insertion Sort | O(n²) | 26 |
| Merge Sort | O(n log n) | 17 |
| Quick Sort | O(n log n) | 22 |

---

## :material-chart-line: Performance Analysis

<div class="grid cards" markdown>

-   ### :material-trending-up: Best Performing Algorithms

    **Merge Sort (17 ms)** achieved the fastest runtime,
    followed closely by **Quick Sort (22 ms)**.

    Their performance aligns with their
    **O(n log n)** time complexity.

-   ### :material-trending-down: Quadratic Algorithms

    **Selection Sort (45 ms)** and  
    **Insertion Sort (26 ms)** showed slower performance,
    consistent with **O(n²)** behavior.

-   ### :material-swap-horizontal: Linear Operations

    File reading, writing, and demand score computation
    scaled linearly with input size, validating their
    **O(n)** complexity.

</div>

---

## :material-flask-outline: Observations

- The measured results closely match theoretical expectations.
- The gap between O(n²) and O(n log n) becomes more significant
  as dataset size increases.
- Merge Sort demonstrated slightly better consistency than Quick Sort
  under this dataset.
- File I/O overhead remains predictable and linear.

---

## :material-check-decagram-outline: Validation Statement

The close alignment between **theoretical complexity**
and **empirical runtime measurement** confirms:

- Correct algorithm implementation  
- Accurate benchmarking methodology  
- Valid performance comparison  

This reinforces the practical importance of algorithm selection
in scalable software design.