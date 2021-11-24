package StreamsFilesDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CountCharacterTypes4 {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\krum\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String,Integer> stat = new HashMap<>();
        stat.put("vowels",0);
        stat.put("consonants",0);
        stat.put("punctuations",0);

        for (String line:lines){
            for (char symbol:line.toCharArray()){
                if (symbol == ' '){
                    continue;
                }
                if (isVowel(symbol)){
                    stat.put("vowels",stat.get("vowels") +1);
                }

                else if (isPunctional(symbol)){
                    stat.put("punctuations",stat.get("punctuations") +1);
                }

                else {
                    stat.put("consonants",stat.get("consonants") +1);
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_task4.txt"));
        writer.write("Vowels: " + stat.get("vowels"));
        writer.newLine();
        writer.write("Consonants: " + stat.get("consonants"));
        writer.newLine();
        writer.write("Punctuations: " + stat.get("punctuations"));
        writer.close();

    }

    private static boolean isVowel(char symbol) {
        return symbol== 'a' ||symbol== 'e' ||symbol== 'o' ||symbol== 'i' ||symbol== 'u';
    }

    private static boolean isPunctional(char symbol) {
        return symbol== '!' ||symbol== '?' ||symbol== '.' ||symbol== ',';
    }
}
