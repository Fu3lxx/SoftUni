package l7associativeArrays;

import java.util.*;

public class p3OddOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] words = scanner.nextLine().split(" ");

        Map<String, Integer> counts =new LinkedHashMap<>();

        for (String word :words){
            String toLowerCase = word.toLowerCase();

            if (counts.containsKey(toLowerCase)){
                counts.put(toLowerCase,counts.get(toLowerCase)+1);
            }
            else {
                counts.put(toLowerCase,1);
            }
        }
        List<String> oddWords = new ArrayList<>();
        for (var entry : counts.entrySet()){
            if (entry.getValue() % 2 ==1){
                oddWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ",oddWords));

        
    }
}
