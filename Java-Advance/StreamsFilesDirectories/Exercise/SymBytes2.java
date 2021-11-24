package StreamsFilesDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SymBytes2 {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\krum\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        }
        catch (NoSuchFileException e){
            System.out.println("There is no such file!");
        }
        catch (IOException io){
            System.out.println("Another error with file");
        }
        int sumLines =0;
        for (String line:lines){
            sumLines += getSumLines(line);
        }
        System.out.println(sumLines);
    }

    private static int getSumLines(String line) {
        int sum = 0;
        for (char symbol: line.toCharArray()){
            sum += symbol;
        }
        return sum;
    }
}
