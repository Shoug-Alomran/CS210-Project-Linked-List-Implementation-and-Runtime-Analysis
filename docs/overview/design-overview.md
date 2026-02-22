# High-Level Solution / System Design Overview

The system analyzes student course registration data to compute course demand
using efficient data structures and sorting algorithms. It follows a
multi-phase workflow designed for correctness, traceability, and runtime
efficiency.

---

## System Overview

<div class="grid cards" markdown>

-   ### :material-file-import-outline: Reading

    **Purpose:** Load and validate data from `Input.txt`  
    **Handled by:** `FileService.java`, `InputValidator.java`

    **Input format:**  
    `studentID;courseID;academicLevel;regTime`

    **Output:** Valid `Registration` objects stored in a custom linked list

-   ### :material-calculator-variant-outline: Processing

    **Purpose:** Compute a demand score for each registration  
    **Handled by:** `DemandScorer.java`

    **Output:** Each linked-list node enriched with a demand score

-   ### :material-file-export-outline: Writing

    **Purpose:** Export processed data before sorting  
    **Handled by:** `FileService.java`

    **Output file:** `Output.txt` (same format + demand score)

-   ### :material-sort: Sorting & Benchmarking

    **Purpose:** Sort registrations by demand score and compare runtimes  
    **Handled by:** `SelectionSort.java`, `InsertionSort.java`, `MergeSort.java`,
    `QuickSort.java`, `Benchmarker.java` / `Timer.java`

    **Outputs:** Sorted result files per algorithm + runtime comparison

</div>

---

## Phase 1 — Reading

**Purpose:** Load and validate data from `Input.txt`  
**Handled by:** `FileService.java` and `InputValidator.java`

<div class="grid cards" markdown>

-   ### :material-text-box-check-outline: Input Handling

    Reads student registration records in the format:  
    `studentID;courseID;academicLevel;regTime`

-   ### :material-shield-check-outline: Validation

    Ensures data validity and skips incorrect or incomplete entries.

-   ### :material-link-variant: Storage

    Stores validated entries as `Registration` objects in a **custom linked list**.

</div>

---

## Phase 2 — Processing

**Purpose:** Compute a demand score for each registration  
**Handled by:** `DemandScorer.java`

<div class="grid cards" markdown>

-   ### :material-numeric: Base Score

    All registrations start with a base score of **50**.

-   ### :material-account-school-outline: Academic Level Multiplier

    - Freshman → ×0.75  
    - Sophomore → ×0.90  
    - Junior → ×1.10  
    - Senior → ×1.25  
    - Graduate → ×1.50  

-   ### :material-clock-outline: Registration Time Factor

    - +10 points (8–10 AM)  
    - +5 points (6–8 AM)  
    - 0 points (12–2 PM)  
    - −5 to −15 points (late afternoon/evening)

-   ### :material-pound: Course ID Priority

    - Odd course codes → +20 points  
    - Even course codes → −10 points  

</div>

The final demand score is computed and stored inside each `Registration` node.

---

## Phase 3 — Writing

**Purpose:** Export processed data to a text file before sorting  
**Handled by:** `FileService.java`

<div class="grid cards" markdown>

-   ### :material-format-list-bulleted: Conversion

    Converts the linked list into an array of `Registration` objects for sorting.

-   ### :material-content-save-outline: Output

    Writes processed records to `Output.txt` in the same format, including demand scores.

</div>

---

## Phase 4 — Sorting and Benchmarking

**Purpose:** Sort by demand score and measure execution time  
**Handled by:** Sorting and benchmarking classes

<div class="grid cards" markdown>

-   ### :material-sort: Sorting Algorithms

    - `SelectionSort.java`  
    - `InsertionSort.java`  
    - `MergeSort.java`  
    - `QuickSort.java`

-   ### :material-timer-outline: Benchmarking

    Measures and compares runtime using a benchmark utility
    (`Benchmarker.java` / `Timer.java`).

-   ### :material-file-multiple-outline: Sorted Outputs

    Exports sorted results to:

    - `Sorted_Output_SS.txt`  
    - `Sorted_Output_IS.txt`  
    - `Sorted_Output_MS.txt`  
    - `Sorted_Output_QS.txt`

</div>

---

## Flow of Execution

The complete program flow is illustrated in the system flowchart below:

??? note "Diagram"
    ![System Flowchart](../assets/images/flowchart.png)