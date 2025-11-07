# Appendix B — Full Source Code

This appendix includes the complete Java implementation used in the **CS210 Project: Linked List Implementation and Runtime Analysis**.  
All files were created and tested using **Visual Studio Code (VS Code)** and compiled with **Java 17**.  
Each file fulfills a specific role within the system’s modular architecture.

---

## 1. Core Data Structures

??? note "Node.java"
    ```java
    public class Node {
        Registration studData; // Field to store Registration data
        Node next; // Field to store next Node reference

        // Task: Constructor to initialize node with Registration
        public Node(Registration studData) {
            this.studData = studData;
            this.next = null;
        }
    }
    ```

??? note "Registration.java"
    ```java
    public class Registration {
        private String studentID;
        private String courseID;
        private int academicLevel;
        private int studTime;
        private double studDemandScore;

        // Constructor
        public Registration(String studentID, String courseID, int academicLevel, int studTime, double studDemandScore) {
            this.studentID = studentID;
            this.courseID = courseID;
            this.academicLevel = academicLevel;
            this.studTime = studTime;
            this.studDemandScore = 0; // temporary value prior to processing
        }

        // Getters and setters
        public String getStudentID() { return studentID; }
        public void setStudentID(String studentID) { this.studentID = studentID; }

        public String getCourseID() { return courseID; }
        public void setCourseID(String courseID) { this.courseID = courseID; }

        public int getAcademicLevel() { return academicLevel; }
        public void setAcademicLevel(int academicLevel) { this.academicLevel = academicLevel; }

        public int getStudTime() { return studTime; }
        public void setStudTime(int studTime) { this.studTime = studTime; }

        public double getStudDemandScore() { return studDemandScore; }
        public void setStudDemandScore(double studDemandScore) { this.studDemandScore = studDemandScore; }

        // Format output line
        @Override
        public String toString() {
            return studentID + ";" + courseID + ";" + academicLevel + ";" + studTime + ";" + Math.round(studDemandScore) + ";";
        }
    }
    ```

---

## 2. Linked List Implementation

??? note "LinkedList.java"
    ```java
    public class LinkedList {
        Node head;
        Node tail;
        int size;

        public void insertNodeAtHead(Registration data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        public void insertNodeAtTail(Registration data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public void deleteNodeByValue(Registration data) {
            if (head == null) return;

            if (head.studData.equals(data)) {
                head = head.next;
                size--;
                return;
            }

            Node prev = head;
            Node curr = head.next;
            while (curr != null) {
                if (curr.studData.equals(data)) {
                    prev.next = curr.next;
                    size--;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }

        public boolean searchKey(Registration data) {
            Node temp = head;
            while (temp != null) {
                if (temp.studData.equals(data)) return true;
                temp = temp.next;
            }
            return false;
        }

        public void displayLinkedList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.studData);
                temp = temp.next;
            }
        }

        public Registration[] convToArray() {
            Registration[] array = new Registration[size];
            Node temp = head;
            int i = 0;
            while (temp != null) {
                array[i++] = temp.studData;
                temp = temp.next;
            }
            return array;
        }
    }
    ```

---

## 3. Supporting Classes

??? note "FileService.java"
    ```java
    import java.io.*;

    public class FileService {
        public static LinkedList readRegistrationsFromFile(String filename) {
            return InputValidator.readAndValidateFile(filename);
        }
    }
    ```

??? note "InputValidator.java"
    ```java
    import java.io.*;
    import java.util.*;

    public class InputValidator {
        public static LinkedList readAndValidateFile(String filename) {
            LinkedList list = new LinkedList();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 4) {
                        String id = parts[0];
                        String course = parts[1];
                        int level = Integer.parseInt(parts[2]);
                        int time = Integer.parseInt(parts[3]);
                        list.insertNodeAtTail(new Registration(id, course, level, time, 0));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            return list;
        }
    }
    ```

??? note "DemandScorer.java"
    ```java
    public class DemandScorer {
        public static void calculateScores(LinkedList list) {
            Node current = list.head;
            while (current != null) {
                Registration reg = current.studData;
                double score = 50; // base score

                // Academic level multiplier
                switch (reg.getAcademicLevel()) {
                    case 1 -> score *= 0.75;
                    case 2 -> score *= 0.90;
                    case 3 -> score *= 1.10;
                    case 4 -> score *= 1.25;
                    case 5 -> score *= 1.50;
                }

                // Time of registration
                int t = reg.getStudTime();
                if (t >= 6 && t < 8) score += 5;
                else if (t >= 8 && t < 10) score += 10;
                else if (t >= 14 && t < 16) score -= 5;
                else if (t >= 16 && t < 20) score -= 10;
                else if (t >= 20) score -= 15;

                // Course priority
                if (reg.getCourseID().endsWith("1") || reg.getCourseID().endsWith("3") || reg.getCourseID().endsWith("5"))
                    score += 20;
                else
                    score -= 10;

                reg.setStudDemandScore(score);
                current = current.next;
            }
        }
    }
    ```