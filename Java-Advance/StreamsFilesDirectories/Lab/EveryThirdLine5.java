package StreamsFilesDirectories.Lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class EveryThirdLine5 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\krum\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);
        PrintStream printStream = new PrintStream("third-line-out.txt");

        int line = 0;
        while (scanner.hasNext()){
            line++;
            if (line % 3 ==0){
                printStream.println(scanner.nextLine());
            }
            else {
                scanner.nextLine();
            }
        }
    }
}
