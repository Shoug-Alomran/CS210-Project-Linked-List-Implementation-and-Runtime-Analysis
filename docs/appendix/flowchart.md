# Appendix A — System Flowchart

This appendix presents the overall system workflow,
from input validation to runtime benchmarking and output generation.

---

## :material-graph-outline: System Execution Flow

<div class="grid cards" markdown>

-   ### :material-play-circle-outline: Program Start

    Initialize execution and prepare runtime measurement.

-   ### :material-file-import-outline: Data Reading & Validation

    Read records from `Input.txt` and validate structure using  
    **InputValidator.java**.

-   ### :material-link-variant: Data Storage

    Store valid records in a custom **Linked List**
    implemented in `LinkedList.java`.

-   ### :material-calculator-variant-outline: Demand Score Calculation

    Compute demand score based on:
    - Base score  
    - Academic level multiplier  
    - Registration time  
    - Course ID priority  

    Implemented in **DemandScorer.java**.

-   ### :material-swap-horizontal: Data Conversion

    Convert the Linked List into an array
    to prepare for sorting.

-   ### :material-sort: Sorting & Benchmarking

    Apply:
    - Selection Sort  
    - Insertion Sort  
    - Merge Sort  
    - Quick Sort  

    Measure runtime using **Benchmarker.java** and **Timer.java**.

-   ### :material-file-export-outline: Output Generation

    Write processed results to `Output.txt`
    and generate sorted output files.

-   ### :material-chart-line: Runtime Summary

    Display performance comparison and terminate program.

</div>

---

## :material-image-outline: System Flowchart Diagram

???+ details "View Flowchart"
    ![System Flowchart](../assets/images/flowchart.png)

    **Figure:** Flowchart illustrating the complete system process
    for course registration analysis.

---

## :material-code-tags: Class Responsibility Mapping

The following Java classes correspond to the flow stages:

- **InputValidator.java** → Data validation  
- **LinkedList.java** → Data storage and traversal  
- **DemandScorer.java** → Demand score computation  
- **Sorting Classes** → Algorithm implementation  
- **Benchmarker.java / Timer.java** → Runtime measurement  

This modular architecture ensures:

- Clear separation of concerns  
- Reusability of components  
- Simplified debugging and testing  
- Scalability for future enhancements  