# CS210 Project – Linked List Implementation and Runtime Analysis

This project implements a **singly linked list** in Java and analyzes its runtime performance.  
It was developed as part of the **CS210: Data Structures** course.

---

## 📌 Project Overview

The project focuses on:
- Implementing a basic **singly linked list** data structure.
- Supporting core operations such as:
  - Insertion
  - Deletion
  - Traversal / Display
  - Search
- Measuring the **theoretical time complexity (Big-O)** of each operation.
- Measuring the **actual runtime** using Java’s `System.nanoTime()`.

---

## 🧱 Files

| File Name        | Description |
|------------------|-------------|
| `Node.java`      | Defines the Node structure (data + pointer to next). |
| `LinkedList.java`| Implements the linked list operations. |
| `Main.java`      | Contains the `main` method to test and demonstrate the linked list. |
| `Timer.java`     | Utility class to measure operation runtimes. |

---

## ⚡ How to Compile and Run

1. Open a terminal in the `src` folder.  
2. Compile all Java files:
   ```bash
   javac *.java
