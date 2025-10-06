# 🎓 CS210 Project — Student Course Registration Analysis  
**Prince Sultan University – Data Structures (CS210)**  
**Developed by:** Shoug Alomran and Layan Bindayel
**Date:** 23/10/2025

---

## Project Description

This project implements a **Student Course Registration Analysis System** that helps analyze student registration data and determine course demand levels.  
The system uses a **custom linked list**, processes thousands of records from `Input.txt`, calculates a **Demand Score** for each registration entry, and sorts the data using **four different sorting algorithms**.

All steps — reading, processing, writing, and sorting — are timed using **Java’s Clock API** for performance analysis.

---

## Objectives

- Implement a **singly linked list** without using Java’s built-in list libraries.  
- Read registration data from an input file (`Input.txt`).  
- Calculate a **Demand Score (0–100)** for each record based on fixed rules.  
- Write processed results to `Output.txt`.  
- Convert the linked list to arrays and sort by Demand Score in **descending order** using:
  - Selection Sort  
  - Insertion Sort  
  - Merge Sort  
  - Quick Sort  
- Measure both **theoretical time complexity (O notation)** and **actual runtime** for each operation.

---

## Demand Score Rules

Each record starts with a base score of **50**, then adjusted by:

| Rule | Condition | Adjustment |
|------|------------|------------|
| **Student Class Multiplier** | 1: −25% • 2: −10% • 3: +10% • 4: +25% • 5: +50% | Multiplies the base score |
| **Time of Day Bonus/Penalty** | 6–8: +5 • 8–10: +10 • 10–12: +5 • 12–14: +0 • 14–16: −5 • 16–20: −10 • After 20: −15 | Adds/subtracts value |
| **Course ID Rule** | Ends with odd number → +20  •  even number → −10 | Adjusts final score |
| **Final Output** | Rounded to nearest integer and limited between 0 and 100 | — |

Example:  
`2015034;CS321;3;10;` → **Demand Score = 60**

---

## Project Architecture

| File | Purpose |
|------|----------|
| **Main.java** | Controls the entire workflow: reading, processing, writing, and sorting. |
| **Node.java** | Defines the node structure used in the linked list (data + next pointer). |
| **LinkedList.java** | Custom singly linked list implementation used to store registration data. |
| **Registration.java** | Represents one registration record (StudentID, CourseID, Class, Time, DemandScore). |
| **FileService.java** | Reads from `Input.txt`, writes processed and sorted data to output files. |
| **InputValidator.java** | Validates input format and skips invalid lines safely. |
| **DemandScorer.java** | Calculates Demand Score for each record using the defined rules. |
| **Comparators.java** | Provides the comparator for sorting (descending by DemandScore). |
| **Sorter.java** | Interface implemented by all sorting algorithm classes. |
| **SelectionSort.java** | Implements Selection Sort. |
| **InsertionSort.java** | Implements Insertion Sort. |
| **MergeSort.java** | Implements Merge Sort. |
| **QuickSort.java** | Implements Quick Sort. |
| **Benchmarker.java** | Measures runtime for each sorting algorithm and generates output files. |
| **Timer.java** | Uses `java.time.Clock` to measure runtime for reading, processing, and writing. |
| **Input.txt** | The dataset file containing registration records. |

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

## Output Files

| File Name | Description |
|------------|-------------|
| **Output.txt** | All records with calculated Demand Scores (unsorted). |
| **Sorted_Output_SS.txt** | Records sorted (descending) by Selection Sort. |
| **Sorted_Output_IS.txt** | Records sorted (descending) by Insertion Sort. |
| **Sorted_Output_MS.txt** | Records sorted (descending) by Merge Sort. |
| **Sorted_Output_QS.txt** | Records sorted (descending) by Quick Sort. |

---

## Example Input / Output

**Input.txt**