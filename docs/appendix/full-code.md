# Appendix B — Full Source Code

This appendix includes the complete Java implementation used in the **CS210 Project: Linked List Implementation and Runtime Analysis**.  
All files were created and tested using **Visual Studio Code (VS Code)** and compiled with **Java 17**.  
Each file fulfills a specific role within the system’s modular architecture.

---

## 1. Core Data Structures

<details><summary>Node.java</summary>

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
</details>
<details><summary>Registration.java</summary>
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
        this.studDemandScore = 0;
    }

    // Getters and Setters
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
</details>
<details><summary>LinkedList.java</summary>
public class LinkedList {
    Node head;
    Node tail;
    int size;

    // Insert node at head
    public void insertNodeAtHead(Registration data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Insert node at tail
    public void insertNodeAtTail(Registration data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Delete node by value
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

    // Search for a node
    public boolean searchKey(Registration data) {
        Node temp = head;
        while (temp != null) {
            if (temp.studData.equals(data)) return true;
            temp = temp.next;
        }
        return false;
    }

    // Display all nodes
    public void displayLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.studData);
            temp = temp.next;
        }
    }

    // Convert linked list to array
    public Registration[] convToArray() {
        Registration[] dataArray = new Registration[size];
        Node temp = head;
        int index = 0;
        while (temp != null) {
            dataArray[index++] = temp.studData;
            temp = temp.next;
        }
        return dataArray;
    }
}
</details>
<details><summary>FileService.java</summary>
import java.io.*;

public class FileService {

    // Read registrations from file into LinkedList
    public static LinkedList readRegistrationsFromFile(String filename) {
        return InputValidator.readAndValidateFile(filename);
    }

    // Write registrations to file
    public static void writeRegistrationsToFile(Registration[] data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Registration r : data) {
                writer.write(r.toString());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }
}
</details>
<details><summary>InputValidator.java</summary>
import java.io.*;
import java.util.*;

public class InputValidator {

    public static LinkedList readAndValidateFile(String filename) {
        LinkedList list = new LinkedList();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    try {
                        String studentID = parts[0];
                        String courseID = parts[1];
                        int academicLevel = Integer.parseInt(parts[2]);
                        int regTime = Integer.parseInt(parts[3]);
                        list.insertNodeAtTail(new Registration(studentID, courseID, academicLevel, regTime, 0));
                    } catch (NumberFormatException e) {
                        // skip invalid line
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }

        return list;
    }
}
</details>
<details><summary>DemandScorer.java</summary>
public class DemandScorer {

    public static void calculateScores(LinkedList list) {
        Node current = list.head;
        while (current != null) {
            Registration r = current.studData;
            double score = 50;

            switch (r.getAcademicLevel()) {
                case 1 -> score *= 0.75; // Freshman
                case 2 -> score *= 0.9;  // Sophomore
                case 3 -> score *= 1.1;  // Junior
                case 4 -> score *= 1.25; // Senior
                case 5 -> score *= 1.5;  // Graduate
            }

            int time = r.getStudTime();
            if (time >= 600 && time < 800) score += 5;
            else if (time >= 800 && time < 1000) score += 10;
            else if (time >= 1400 && time < 1600) score -= 5;
            else if (time >= 1600 && time < 2000) score -= 10;
            else if (time >= 2000) score -= 15;

            if (Character.getNumericValue(r.getCourseID().charAt(r.getCourseID().length() - 1)) % 2 == 0)
                score -= 10;
            else
                score += 20;

            r.setStudDemandScore(score);
            current = current.next;
        }
    }
}
</details>
<details><summary>SelectionSort.java</summary>
public class SelectionSort implements Sorter {
    @Override
    public void sort(Registration[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getStudDemandScore() > array[maxIndex].getStudDemandScore()) {
                    maxIndex = j;
                }
            }
            Registration temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }

    @Override
    public String name() {
        return "Selection Sort";
    }
}
</details>
<details><summary>InsertionSort.java</summary>
public class InsertionSort implements Sorter {
    @Override
    public void sort(Registration[] array) {
        for (int i = 1; i < array.length; i++) {
            Registration current = array[i];
            double currentScore = current.getStudDemandScore();
            int j = i - 1;

            while (j >= 0 && array[j].getStudDemandScore() < currentScore) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    @Override
    public String name() {
        return "Insertion Sort";
    }
}
</details>
<details><summary>MergeSort.java</summary>
public class MergeSort implements Sorter {
    @Override
    public void sort(Registration[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(Registration[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(Registration[] array, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        Registration[] L = new Registration[n1];
        Registration[] R = new Registration[n2];
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].getStudDemandScore() >= R[j].getStudDemandScore())
                array[k++] = L[i++];
            else
                array[k++] = R[j++];
        }
        while (i < n1) array[k++] = L[i++];
        while (j < n2) array[k++] = R[j++];
    }

    @Override
    public String name() {
        return "Merge Sort";
    }
}
</details>
<details><summary>QuickSort.java</summary>
public class QuickSort implements Sorter {
    @Override
    public void sort(Registration[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Registration[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(Registration[] array, int low, int high) {
        double pivot = array[high].getStudDemandScore();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].getStudDemandScore() >= pivot) {
                i++;
                Registration temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Registration temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    @Override
    public String name() {
        return "Quick Sort";
    }
}
</details>
<details><summary>Timer.java</summary>
public class Timer {
    // Private variables for safety, no other class can access these directly and effect the elapsed time.
    private long startTime;
    private long endTime;

    // Method to start timer
    public void start() {
        startTime = System.currentTimeMillis(); // Simpler than nanoTime
    }

    // Method to stop timer
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Method to get elapsed time in milliseconds
    public long getElapsedTimeMillis() {
        return endTime - startTime;
    }
}
</details>
<details><summary>Benchmarker.java</summary>
public class Benchmarker {

    private static Registration[] makeCopy(Registration[] original) {
        Registration[] copy = new Registration[original.length];
        for (int i = 0; i < original.length; i++) copy[i] = original[i];
        return copy;
    }

    public static void runAllSorts(Registration[] originalArray) {
        System.out.println("--- RUNNING ALL SORTS ---");
        Timer timer = new Timer();

        Registration[] copy1 = makeCopy(originalArray);
        timer.start();
        new SelectionSort().sort(copy1);
        timer.stop();
        FileService.writeRegistrationsToFile(copy1, "Sorted_Output_SS.txt");
        System.out.println("Selection Sort: " + timer.getElapsedTimeMillis() + " ms");

        Registration[] copy2 = makeCopy(originalArray);
        timer.start();
        new InsertionSort().sort(copy2);
        timer.stop();
        FileService.writeRegistrationsToFile(copy2, "Sorted_Output_IS.txt");
        System.out.println("Insertion Sort: " + timer.getElapsedTimeMillis() + " ms");

        Registration[] copy3 = makeCopy(originalArray);
        timer.start();
        new MergeSort().sort(copy3);
        timer.stop();
        FileService.writeRegistrationsToFile(copy3, "Sorted_Output_MS.txt");
        System.out.println("Merge Sort: " + timer.getElapsedTimeMillis() + " ms");

        Registration[] copy4 = makeCopy(originalArray);
        timer.start();
        new QuickSort().sort(copy4);
        timer.stop();
        FileService.writeRegistrationsToFile(copy4, "Sorted_Output_QS.txt");
        System.out.println("Quick Sort: " + timer.getElapsedTimeMillis() + " ms");
    }
}
</details>
<details><summary>Main.java</summary>
public class Main {
    public static void main(String[] args) {

        System.out.println("Starting program...");
        Timer timer = new Timer();

        // Read input file
        timer.start();
        LinkedList list = FileService.readRegistrationsFromFile("Input.txt");
        timer.stop();
        System.out.println("File reading completed in: " + timer.getElapsedTimeMillis() + " ms");

        System.out.println("Starting demand score calculations...");
        timer.start();
        DemandScorer.calculateScores(list);
        timer.stop();
        System.out.println("Demand score calculations completed in: " + timer.getElapsedTimeMillis() + " ms");

        // Convert list to array and write unsorted file
        Registration[] data = list.convToArray();
        FileService.writeRegistrationsToFile(data, "Output.txt");
        System.out.println("Saved unsorted data to Output.txt");

        // Benchmark sorting algorithms
        System.out.println("Starting sorting algorithms...");
        Benchmarker.runAllSorts(data);
        System.out.println("All sorting completed and results saved.");
    }
}
</details>