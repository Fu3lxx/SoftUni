package l7associativeArrays;

import java.util.*;

public class p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = Integer.parseInt(scanner.nextLine());
        Map<String , List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i <times ; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

           synonyms.putIfAbsent(word,new ArrayList<>());
           synonyms.get(word).add(synonym);
        }
        for (Map.Entry<String,List<String>> entry: synonyms.entrySet()){
            System.out.println(entry.getKey() + " - " + String.join(", " , entry.getValue()));
        }
    }
}
