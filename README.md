# CS210 Project — Student Course Registration Analysis  
Prince Sultan University – Data Structures (CS210)  
**Developed by:** Shoug Fawaz Alomran and Layan Hesham Bindayel  
**Submission Date:** 23/10/2025  

---

## Project Description

This project implements a Student Course Registration Analysis System that processes registration data from a text file and calculates a Demand Score for each record.  
The program uses a custom singly linked list to store the data, applies defined rules to evaluate course demand, and then sorts the processed results using four classic sorting algorithms.  

All stages — reading, processing, writing, and sorting — are timed using Java’s `Clock` class to measure actual performance.

---

## Objectives

- Implement a singly linked list (without using Java’s `ArrayList` or `LinkedList` classes).  
- Read student registration data from `Input.txt`.  
- Compute a Demand Score (0–100) for each record based on the given rules.  
- Save results in `Output.txt`.  
- Convert the linked list into arrays and sort by Demand Score in descending order using:  
  1. Selection Sort  
  2. Insertion Sort  
  3. Merge Sort  
  4. Quick Sort  
- Measure both theoretical time complexity (Big-O) and actual runtime using the `java.time.Clock` API.

---

## Demand Score Rules

Each record starts with a base score of 50 and is adjusted by the following rules:

| Rule | Condition | Adjustment |
|------|------------|------------|
| Student Class Multiplier | 1 → −25% • 2 → −10% • 3 → +10% • 4 → +25% • 5 → +50% | Multiplies the base score |
| Course ID Rule | If Course ID ends with an odd number → +20  •  If even → −10 | Adjusts final score |
| Final Output | Rounded to the nearest integer and limited between 0 and 100 | — |

**Example:**  
`2015034;CS321;3;10;` → Demand Score = 60

---

## Project Architecture

| File | Purpose |
|------|----------|
| Main.java | Controls the full program workflow: reading, processing, writing, and sorting. |
| Node.java | Defines the node structure used in the linked list. |
| LinkedList.java | Custom singly linked list implementation used to store registration records. |
| Registration.java | Represents a single registration record (StudentID, CourseID, Class, Time, DemandScore). |
| FileService.java | Handles file operations — reading `Input.txt` and writing all output files. |
| InputValidator.java | Validates data format and skips invalid or incomplete lines. |
| DemandScorer.java | Calculates the Demand Score based on the defined rules. |
| Comparators.java | Provides comparators for sorting in descending Demand Score order. |
| Sorter.java | Interface implemented by all sorting algorithm classes. |
| SelectionSort.java | Implements Selection Sort algorithm. |
| InsertionSort.java | Implements Insertion Sort algorithm. |
| MergeSort.java | Implements Merge Sort algorithm. |
| QuickSort.java | Implements Quick Sort algorithm. |
| Benchmarker.java | Measures runtimes for each sorting algorithm and saves the results. |
| Timer.java | Uses `java.time.Clock` to measure execution durations. |
| Input.txt | Input dataset containing 3000+ registration records. |

---

## Runtime Analysis

| Operation | Theoretical Complexity | Runtime Measured Using |
|------------|-----------------------|------------------------|
| Read Input | O(n) | Clock |
| Process Demand Score | O(n) | Clock |
| Write Output | O(n) | Clock |
| Selection Sort | O(n²) | Clock |
| Insertion Sort | O(n²) | Clock |
| Merge Sort | O(n log n) | Clock |
| Quick Sort | O(n log n) average (O(n²) worst) | Clock |

Each phase prints its runtime in milliseconds to the console.

---

## 📄 Project Documentation

The full project documentation is available here:  
[View CS210 Project Report (MkDocs Site)](https://linkedlist.shoug-tech.com)

---

## Output Files

| File Name | Description |
|------------|-------------|
| Output.txt | Contains all records with their calculated Demand Scores (unsorted). |
| Sorted_Output_SS.txt | Records sorted in descending order using Selection Sort. |
| Sorted_Output_IS.txt | Records sorted in descending order using Insertion Sort. |
| Sorted_Output_MS.txt | Records sorted in descending order using Merge Sort. |
| Sorted_Output_QS.txt | Records sorted in descending order using Quick Sort. |

