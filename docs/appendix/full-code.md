# Appendix B — Full Source Code

This appendix includes the complete Java implementation used in the  
**CS210 Project — Linked List Implementation and Runtime Analysis**.

All files were developed in **Visual Studio Code (VS Code)**  
and compiled using **Java 17**.

Each file plays a defined role within the system’s modular architecture.

---

## :material-database-outline: 1. Core Data Structures

???+ details "Node.java — Linked List Node Structure"
    ```java
    public class Node {
        Registration studData;
        Node next;

        public Node(Registration studData) {
            this.studData = studData;
            this.next = null;
        }
    }
    ```

???+ details "Registration.java — Data Model"
    ```java

    public class Registration {
        private String studentID;
        private String courseID;
        private int academicLevel;
        private int studTime;
        private double studDemandScore;

        public Registration(String studentID, String courseID, int academicLevel, int studTime, double studDemandScore) {
            this.studentID = studentID;
            this.courseID = courseID;
            this.academicLevel = academicLevel;
            this.studTime = studTime;
            this.studDemandScore = 0;
        }

        public String getStudentID() { return studentID; }
        public String getCourseID() { return courseID; }
        public int getAcademicLevel() { return academicLevel; }
        public int getStudTime() { return studTime; }
        public double getStudDemandScore() { return studDemandScore; }

        public void setStudDemandScore(double studDemandScore) {
            this.studDemandScore = studDemandScore;
        }

        @Override
        public String toString() {
            return studentID + ";" + courseID + ";" + academicLevel + ";" + studTime + ";" + Math.round(studDemandScore) + ";";
        }
    }
    ```

---

## :material-link-variant: 2. Linked List Implementation

???+ details "LinkedList.java — Custom Implementation"
    ```java

    public class LinkedList {
        Node head;
        Node tail;
        int size;

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

## :material-cog-outline: 3. Supporting Classes

???+ details "FileService.java — File Handling Layer"
    ```java
    import java.io.*;

    public class FileService {
        public static LinkedList readRegistrationsFromFile(String filename) {
            return InputValidator.readAndValidateFile(filename);
        }
    }
    ```

???+ details "InputValidator.java — Input Processing"
    ```java

    import java.io.*;

    public class InputValidator {
        public static LinkedList readAndValidateFile(String filename) {
            LinkedList list = new LinkedList();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 4) {
                        list.insertNodeAtTail(
                            new Registration(
                                parts[0],
                                parts[1],
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]),
                                0
                            )
                        );
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            return list;
        }
    }
    ```

???+ details "DemandScorer.java — Demand Calculation Logic"
    ```java
    
    public class DemandScorer {
        public static void calculateScores(LinkedList list) {
            Node current = list.head;
            while (current != null) {
                Registration reg = current.studData;
                double score = 50;

                switch (reg.getAcademicLevel()) {
                    case 1 -> score *= 0.75;
                    case 2 -> score *= 0.90;
                    case 3 -> score *= 1.10;
                    case 4 -> score *= 1.25;
                    case 5 -> score *= 1.50;
                }

                int t = reg.getStudTime();
                if (t >= 6 && t < 8) score += 5;
                else if (t >= 8 && t < 10) score += 10;
                else if (t >= 14 && t < 16) score -= 5;
                else if (t >= 16 && t < 20) score -= 10;
                else if (t >= 20) score -= 15;

                if (reg.getCourseID().endsWith("1") ||
                    reg.getCourseID().endsWith("3") ||
                    reg.getCourseID().endsWith("5"))
                    score += 20;
                else
                    score -= 10;

                reg.setStudDemandScore(score);
                current = current.next;
            }
        }
    }
    ```