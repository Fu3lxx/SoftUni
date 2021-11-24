package l7associativeArrays;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;

public class p3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <String> list = Arrays.stream(scanner.nextLine().split(" ")).map(String::toLowerCase).collect(Collectors.toList());
        Map <String,Integer> times = new LinkedHashMap<>();

        for (String element :list){

            if (!times.containsKey(element)){
                times.put(element,1);
            }else {
                times.put(element,times.get(element)+1);
                //counter.put(num,counter.get(num)+1);
            }
        }
        List<String> oddWords = new ArrayList<>();
        for (var entry : times.entrySet()){
            if (entry.getValue() % 2 ==1){
                oddWords.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ",oddWords));
    }
}
