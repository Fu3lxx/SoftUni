package l6objectAndClassesLab;

import java.util.*;
import java.util.stream.Collectors;

public class testFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <String> text= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Random random = new Random();

        while (text.size()>0){
            String word = text.remove(random.nextInt(text.size()));
            System.out.println(word);
        }




    }
}
