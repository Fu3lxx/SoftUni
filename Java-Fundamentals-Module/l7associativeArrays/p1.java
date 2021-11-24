package l7associativeArrays;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        Map <Double , Integer> counter = new TreeMap<>();

        for (double num: numbers){
            if (!counter.containsKey(num)){
                counter.put(num,1);
            }else {
                counter.put(num,counter.get(num)+1);
            }
        }
        for (Map.Entry<Double, Integer> entry : counter.entrySet()){
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d\n",df.format(entry.getKey()),entry.getValue());
        }
    }
}
