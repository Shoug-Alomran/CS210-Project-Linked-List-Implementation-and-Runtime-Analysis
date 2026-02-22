# Interpretation of Results

The empirical runtime data and theoretical complexity analysis
demonstrate strong alignment between predicted and observed behavior
for all implemented sorting algorithms.

---

## :material-chart-line: Key Observations

<div class="grid cards" markdown>

-   ### :material-trending-up: Superior Performance

    **Merge Sort** and **Quick Sort** consistently outperformed
    the other algorithms due to their
    **O(n log n)** time complexity.

-   ### :material-trending-down: Quadratic Growth

    **Insertion Sort** and **Selection Sort**
    exhibited noticeable runtime growth,
    consistent with **O(n²)** complexity.

-   ### :material-check-circle-outline: Theory Validated

    The measured runtimes closely matched theoretical expectations,
    validating both the correctness of implementation
    and the reliability of benchmarking.

</div>

---

## :material-lightbulb-outline: Insights & Lessons Learned

<div class="grid cards" markdown>

-   ### :material-scale-balance: Simplicity vs. Efficiency

    Simpler algorithms (Selection and Insertion Sort)
    are easier to implement and reason about,
    but do not scale efficiently as data size increases.

-   ### :material-expand-all-outline: Scalability Matters

    Divide-and-conquer algorithms (Merge and Quick Sort)
    maintain significantly better growth behavior,
    making them suitable for large datasets.

-   ### :material-cog-outline: System-Level Optimization

    Efficient file handling, structured scoring logic,
    and a modular linked-list implementation
    contributed to stable and predictable performance.

</div>

---

## :material-flask-outline: Overall Interpretation

This project reinforces a fundamental principle in algorithm design:

> Theoretical complexity directly influences practical runtime behavior.

The results demonstrate how informed algorithm selection
significantly impacts scalability, efficiency, and system performance
in real-world applications.