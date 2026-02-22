# Introduction

Sorting algorithms are fundamental to computer science and play a critical
role in organizing, processing, and retrieving data efficiently. They form
the backbone of numerous applications, including databases, scheduling
systems, analytics platforms, and search operations.

The efficiency of a system often depends on how effectively it can sort and
structure its data. Understanding algorithmic behavior and performance
characteristics is essential for building scalable and optimized solutions.

---

<div class="grid cards" markdown>

-   ### :material-book-open-outline: Background

    Sorting improves data accessibility and simplifies operations such as
    searching, merging, and filtering. Different algorithms offer distinct
    trade-offs in:

    - Time complexity  
    - Space complexity  
    - Implementation simplicity  
    - Stability and scalability  

    Algorithms such as **Selection Sort**, **Insertion Sort**, **Merge Sort**,
    and **Quick Sort** illustrate how design decisions affect runtime and memory.

-   ### :material-help-circle-outline: Problem Statement

    This project compares the performance of four sorting algorithms through
    theoretical complexity analysis and empirical runtime measurement under a
    controlled environment.

    All methods are implemented using the same dataset to ensure a fair
    comparison. The dataset consists of student registration records, enabling
    a realistic academic use case such as identifying course demand trends.

    **Key question:** Which algorithm performs best as input size increases?

</div>

---

## Scope of Work

<div class="grid cards" markdown>

-   ### :material-link-variant: Data Structure

    - Implement a custom **Linked List** to store registration records  
    - Convert the list into an array for sorting  

-   ### :material-calculator-variant-outline: Demand Computation

    - Compute a **demand score** per record  
    - Use multiple weighted factors for scoring  

-   ### :material-sort: Sorting Algorithms

    Implement and apply:

    - Selection Sort  
    - Insertion Sort  
    - Merge Sort  
    - Quick Sort  

-   ### :material-timer-outline: Performance Measurement

    - Measure runtime for each algorithm  
    - Compare results under consistent conditions  
    - Interpret performance differences at scale  

</div>

---

## Objective

<div class="grid cards" markdown>

-   ### :material-chart-line: Performance Understanding

    Explore the relationship between algorithmic design and runtime efficiency,
    especially under large-scale datasets.

-   ### :material-scale-balance: Trade-off Analysis

    Evaluate practical trade-offs between simpler approaches and
    divide-and-conquer algorithms (time vs. space vs. implementation cost).

-   ### :material-flask-outline: Empirical Validation

    Compare theoretical complexity expectations with measured runtimes to
    highlight real-world behavior.

</div>

---

!!! note "Evaluation Focus"
    The comparison is performed using the same dataset and environment across
    all implementations to keep the results consistent and comparable.