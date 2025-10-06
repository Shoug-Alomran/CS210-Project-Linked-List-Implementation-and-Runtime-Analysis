# CS210 Project — Student Course Registration Analysis

This project implements a **student course registration analysis system** using Java.  
It processes registration data to calculate a *Demand Score* for each record and analyzes sorting algorithm performance.  
Developed as part of **CS210: Data Structures** at *Prince Sultan University*.

---

## Project Overview

The system reads student registration data from a text file (`Input.txt`), processes each record according to defined rules, and outputs:
- `Output.txt` → all records with calculated Demand Scores.
- Four sorted files (`Sorted_Output_SS.txt`, `Sorted_Output_IS.txt`, `Sorted_Output_MS.txt`, `Sorted_Output_QS.txt`) → sorted in **descending order** by Demand Score using:
  1. Selection Sort  
  2. Insertion Sort  
  3. Merge Sort  
  4. Quick Sort

The project also measures **theoretical complexity** *(Big-O)* and **actual runtime** using Java’s `Clock` class.

---

## Processing Rules (Demand Score)

Each registration starts with a **base score of 50**, adjusted as follows:

| Rule | Description | Adjustment |
|------|--------------|-------------|
| Student Class | 1: −25% • 2: −10% • 3: +10% • 4: +25% • 5: +50% | Multiplier |
| Time of Day | 6–8: +5 • 8–10: +10 • 10–12: +5 • 12–14: 0 • 14–16: −5 • 16–20: −10 • after 20: −15 | Bonus/Penalty |
| Course Priority | Ends with odd number → +20 • even number → −10 | Adjustment |
| Final Score | Rounded and clamped between 0–100 | — |

---

## Files and Structure

| File | Description |
|------|--------------|
| `Main.java` | Controls the full workflow: read → process → write → sort → benchmark. |
| `Node.java` | Defines the linked-list node structure (data + pointer). |
| `LinkedList.java` | Implements the custom singly linked list used for data storage. |
| `Registration.java` | Represents one student registration record and its demand score. |
| `FileService.java` | Handles reading `Input.txt` and writing all output files. |
| `DemandScorer.java` | Applies all scoring rules to compute the Demand Score. |
| `Comparators.java` | Provides the descending Demand Score comparator. |
| `Timer.java` | Utility class using `java.time.Clock` to measure runtime durations. |
| `SelectionSort.java` | Implements Selection Sort algorithm. |
| `InsertionSort.java` | Implements Insertion Sort algorithm. |
| `MergeSort.java` | Implements Merge Sort algorithm. |
| `QuickSort.java` | Implements Quick Sort algorithm. |
| `Benchmarker.java` | Runs and times all sorting algorithms, generating sorted files. |
| `Input.txt` | Input data file with 3000+ student registration records. |

---

## Runtime Analysis

Each phase’s runtime is measured and printed to the console using the **Java Clock API**.

| Operation | Theoretical Complexity | Runtime Method |
|------------|-----------------------|----------------|
| Read File | O(n) | Clock |
| Process Demand Score | O(n) | Clock |
| Write File | O(n) | Clock |
| Selection Sort | O(n²) | Clock |
| Insertion Sort | O(n²) (best O(n)) | Clock |
| Merge Sort | O(n log n) | Clock |
| Quick Sort | O(n log n) average (worst O(n²)) | Clock |

---

## Sample Workflow

1. **Read Input** → from `Input.txt`  
2. **Process Demand Score** → apply all scoring rules  
3. **Write Output** → to `Output.txt`  
4. **Convert LinkedList to Array** → for sorting  
5. **Run 4 Sorting Algorithms** → Selection, Insertion, Merge, Quick  
6. **Save Sorted Results** → in respective output files  
7. **Print Runtimes** → for all phases

---

## How to Compile and Run

1. Open a terminal in the `src/` folder.  
2. Compile all Java files:
   ```bash
   javac *.java