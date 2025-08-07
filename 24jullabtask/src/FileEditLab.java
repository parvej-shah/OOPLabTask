import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileEditLab {
    private final String filePath;
    public FileEditLab(String filePath) {
        this.filePath = filePath;
    }

    public void bufferedWrite(String text){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));){
            bw.write("Written by buffered Writer");
            bw.newLine();
            bw.write(text);
            bw.newLine();
            bw.write("_".repeat(text.length()));
            bw.newLine();
        }
        catch(IOException ioe){
            System.out.println("Error writing to file");
        }
    }

    public void bufferedRead(){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath));){
            System.out.println("Reading by buffered Reader");
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException ioe){
            System.out.println("Error Reading from file");
        }
    }

    public void fileWrite(String text) {
        try(FileWriter fw = new FileWriter(filePath,true)){
            fw.write("Written by FileWriter");
            fw.write("\n");
            fw.write(text);
            fw.write("\n");
            fw.write("_".repeat(text.length()));
            fw.write("\n");
        }
        catch(IOException ioe){
            System.out.println("Error writing to file");
        }
    }

    public void fileRead(){
        try(FileReader fr = new FileReader(filePath)){
            System.out.println("Reading by FileReader");
            int ch;
            while((ch = fr.read()) != -1){
                System.out.print((char)ch);
            }
        }
        catch(IOException ioe){
            System.out.println("Error reading from file");
        }
    }

    public void latestNioReader(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            System.out.println("\nReading nio Reader");
            for(String line : lines){
                System.out.println(line);
            }
        }
        catch(IOException ioe){
            System.out.println("Error reading from file");
        }
    }

    public void latestNioWriter(String text){
        try{
            List<String> lines = Arrays.asList(
                "Written by NIO Writer",
                text,
                "_".repeat(text.length())
            );
            Files.write(Paths.get(filePath), lines, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
