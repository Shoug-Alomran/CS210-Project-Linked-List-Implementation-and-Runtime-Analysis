public class FileService {

    // Method to read registrations from Input.txt into LinkedList
    public static LinkedList readRegistrationsFromFile(String filename) {
        return InputValidator.readAndValidateFile(filename);
    }
    // Task: Method to write array of registrations to Output.txt
     public static void writeRegistrationsToFile(Registration[] array, String filename) {
        // TODO: Implement output writing
    }
}
