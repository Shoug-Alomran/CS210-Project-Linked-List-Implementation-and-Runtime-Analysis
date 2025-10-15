import java.io.*;
import java.util.*;

public class InputValidator {

    private static Set<String> validCourses = new HashSet<>(); // Empty list to store valid course codes extracted from
                                                               // text file

    // Method to validate file path exists and is readable.
    public static boolean isValidFilePath(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.canRead();
    }

    // Method to read and validate input file.
    public static LinkedList readAndValidateFile(String input) {
        LinkedList registrations = new LinkedList(); // Create instance of Layan's list (LinkedList class).

        // Check if file exists and is readable to avoid FileNotFoundException.
        if (!isValidFilePath(input)) {
            System.out.println(
                    "ERROR: File '" + input + "' not found or not readable. Please check that the file exists.");
            return registrations; // Stop the entire method
        }
        // If file is found, proceed to the BufferedReader section to actually read the
        // file.
        try (BufferedReader list = new BufferedReader(new FileReader(input))) { // BufferedReader to read the input file
                                                                                // more efficiently. It reads larger
                                                                                // chunks of data at a time, reducing
                                                                                // the number of I/O operations.
            String line;
            while ((line = list.readLine()) != null) { // readLine is like nextLine but for BufferedReader.
                String[] parts = line.split(";"); // Split line into parts based on semicolon.
                if (parts.length != 4) { // We are expecting exactly 4 fields per line.
                    System.out.println("Invalid entry (wrong number of fields): " + line);
                    continue; // Skip invalid entry
                }
                // Example line: 2021555;CS222;2;10;
                String studentID = parts[0];
                String courseID = parts[1];

                // We need to parse integers to convert from String.
                try {
                    int academicLevel = Integer.parseInt(parts[2]);
                    int studyTime = Integer.parseInt(parts[3]);

                    // Validate non-empty string (for names, course titles)
                    if (studentID.isEmpty() || courseID.isEmpty()) {
                        System.out.println("Invalid string field in entry: " + line);
                        continue; // Skip invalid entry
                    }
                    // Validate studentId.
                    if (studentID.length() != 7 && studentID.length() != 5 ) { // Assuming student ID should be exactly 7 or 5 characters.
                        System.out.println("Invalid student ID in entry: " + line);
                        continue; // Skip invalid entry
                    }
                    // Validate credits/section as positive integers within range.
                    if (academicLevel < 1 || academicLevel > 5) { // Student class should be 1-5.
                        System.out.println("Invalid academic level in entry: " + line);
                        continue; // Skip invalid entry
                    }

                    if (studyTime < 0 || studyTime > 23) { // Assuming time is in 24-hour format
                        System.out.println("Invalid study time in entry: " + line);
                        continue; // Skip invalid entry
                    }

                    // If all validations pass, add courseID to validCourses Hashset. (Previously it
                    // was empty).
                    validCourses.add(courseID);

                    // Create Registration object and add to linked list.
                    Registration reg = new Registration(studentID, courseID, academicLevel, studyTime, 0);
                    registrations.insertNodeAtTail(reg);
                    System.out.println("VALID: " + line);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in entry: " + line);
                    continue; // Skip invalid entry.
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return registrations;
    }
}