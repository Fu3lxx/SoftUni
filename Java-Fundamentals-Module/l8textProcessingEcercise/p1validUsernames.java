package l8textProcessingEcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p1validUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).filter(e -> (e.length() >= 3) && (e.length() <= 16))
                .filter(e -> (!e.contains("@") || !e.contains("&") || !e.contains("!") || !e.contains("#") || !e.contains("$") || !e.contains("%") || !e.contains(" ")) )
                .collect(Collectors.toList());


        input.removeIf(pass -> pass.contains("@") || pass.contains("&") || pass.contains("!") || pass.contains("#") ||
                pass.contains("$") || pass.contains("%") || pass.contains(" "));

        for (String print : input){
            System.out.println(print);
        }
    }
}
