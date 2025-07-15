import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataHandler {

    // Method to save participant data to a file
    public static void saveToFile(Participant participant, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("------------------------------------------\n");
            writer.write(participant.toString());
            writer.write("-------------------------------------------\n\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
