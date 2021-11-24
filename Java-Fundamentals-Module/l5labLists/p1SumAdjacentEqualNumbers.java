package l5labLists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p1SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List <Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i <numbers.size()-1 ; i++) {
            double current = numbers.get(i);
            double adjacent = numbers.get(i+1);
            if (current==adjacent){
                numbers.remove(i+1);
                numbers.set(i,current+adjacent);
                i=-1;
            }
        }
        String output=joinElementsByDelimiter(numbers," ");
        System.out.println(output);
    }
    public static String joinElementsByDelimiter (List<Double> numbers , String delimiter){
        String output = "";
        for (Double item :numbers){
            output+= (new DecimalFormat("0.#").format(item))+delimiter;
        }
        return output;
    }
}
