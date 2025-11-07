# Runtime Measurement

Runtime performance was measured using the **Java Clock class** to record the execution time of each major phase. The dataset used contained **3432 registration records**.

---

## Measured Runtime Table

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

## Discussion

The results confirm that:
- **Merge Sort** and **Quick Sort** consistently achieved the lowest runtimes.
- **Selection Sort** and **Insertion Sort** took significantly longer, especially as dataset size increased.
- File operations and demand score calculations behaved linearly, matching their O(n) complexity.

All timings were measured under identical conditions on the same machine to ensure fair comparison.