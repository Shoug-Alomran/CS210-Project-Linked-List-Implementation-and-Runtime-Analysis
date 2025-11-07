# Interpretation of Results

The runtime data and theoretical analysis both confirm the expected behavior of each sorting algorithm.

---

## Key Observations

1. **Merge Sort** and **Quick Sort** showed superior performance because of their **O(n log n)** complexity.
2. **Insertion Sort** and **Selection Sort** became slower as the dataset grew, reflecting their **O(n²)** cost.
3. The actual runtime differences aligned with theory, validating both the implementation and analysis.

---

## Insights and Lessons Learned

- **Trade-off between simplicity and efficiency:**  
  Simple algorithms like Insertion and Selection Sort are easier to understand but inefficient on large datasets.
- **Scalability:**  
  Efficient algorithms (Merge and Quick Sort) handle larger data with much less growth in runtime.
- **System efficiency:**  
  The use of a custom linked list, efficient file handling, and optimized scoring ensured consistent performance.

---

## Visual Summary (Optional)

If you have a bar chart or runtime plot, embed it here:

```markdown
![Runtime Comparison](../assets/images/runtime_chart.png)