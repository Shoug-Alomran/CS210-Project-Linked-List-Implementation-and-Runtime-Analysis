# High-Level Solution / System Design Overview

The system was designed to analyze student course registration data and compute course demand using efficient data structures and sorting algorithms. It follows a structured, multi-phase workflow that ensures both correctness and performance efficiency.

---

## System Overview

The system is divided into four primary phases:

1. **Reading**
2. **Processing**
3. **Writing**
4. **Sorting and Benchmarking**

Each phase corresponds to specific Java classes that handle file input/output, data storage, demand score calculation, and sorting analysis.

---

## 1. Reading Phase

- **Purpose:** Load and validate data from `Input.txt`.  
- **Handled by:** `FileService.java` and `InputValidator.java`.  
- **Process:**
  - Reads student registration data in the format  
    `studentID;courseID;academicLevel;regTime`
  - Ensures data validity and skips any incorrect or incomplete entries.
  - Stores validated records as `Registration` objects inside a custom linked list.

---

## 2. Processing Phase

- **Purpose:** Calculate a demand score for each registration based on specific criteria.  
- **Handled by:** `DemandScorer.java`.  
- **Calculation Rules:**
  - **Base score:** 50 points for all students.
  - **Academic level multiplier:**
    - Freshman → ×0.75  
    - Sophomore → ×0.90  
    - Junior → ×1.10  
    - Senior → ×1.25  
    - Graduate → ×1.50  
  - **Time of registration:**
    - +10 points for early registration (8–10 AM)  
    - +5 points for early morning (6–8 AM)  
    - 0 points for midday (12–2 PM)  
    - −5 to −15 points for late afternoon or evening registration.
  - **Course ID priority:**
    - Odd course codes → +20 points (high-priority)
    - Even course codes → −10 points (low-priority)

The total demand score is computed and stored in each `Registration` node.

---

## 3. Writing Phase

- **Purpose:** Output the processed data to a text file before sorting.  
- **Handled by:** `FileService.java`.  
- **Process:**  
  - Converts the linked list into an array of `Registration` objects.  
  - Writes each record into `Output.txt` in the same data format, including demand scores.

---

## 4. Sorting and Benchmarking Phase

- **Purpose:** Sort registration data based on demand scores and measure execution times.  
- **Handled by:** Sorting and benchmarking classes:
  - `SelectionSort.java`
  - `InsertionSort.java`
  - `MergeSort.java`
  - `QuickSort.java`
  - `Benchmarker.java` / `Timer.java`
- **Process:**
  - Applies each sorting algorithm to the same dataset.
  - Measures and compares runtimes using Java’s `Clock` class.
  - Exports sorted results to:
    - `Sorted_Output_SS.txt`
    - `Sorted_Output_IS.txt`
    - `Sorted_Output_MS.txt`
    - `Sorted_Output_QS.txt`

---

## 5. Flow of Execution

The complete program flow is illustrated in the system flowchart below:

![System Flowchart](../assets/images/flowchart.png)
