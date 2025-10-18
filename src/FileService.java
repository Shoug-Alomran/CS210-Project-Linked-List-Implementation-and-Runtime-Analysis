import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    // Method to read registrations from Input.txt into LinkedList
    public static LinkedList readRegistrationsFromFile(String filename) {
        return InputValidator.readAndValidateFile(filename);
    }
    // Method to write array of registrations to Output.txt
   public static void writeRegistrationsToFile(Registration[] array, String filename) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (Registration reg : array) {
                if (reg != null) {//Checks for null entries to avoid file writing loop from crashing with NullPointerException
                    writer.write(reg.toString());
                    writer.newLine();
                }
            }

            writer.close();
            System.out.println("Registrations successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}



