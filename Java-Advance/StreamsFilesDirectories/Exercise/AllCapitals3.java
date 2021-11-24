package StreamsFilesDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AllCapitals3 {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\krum\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines= new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error");
        }


        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        for (String line:lines){
            writer.write(line.toUpperCase(Locale.ROOT));
            writer.newLine();
        }

        writer.close();
    }
}
