package l5moreExerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p1Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String text = scanner.nextLine();
        StringBuilder command = new StringBuilder(text);
        String output="";

        for (int i = 0; i <list.size() ; i++) {
            int sum=0;
            int currentNum =list.get(i);
            while (currentNum>0){
                int current=currentNum%10;
                sum+=current;
                currentNum/=10;
            }
            while (sum>command.length()){
                sum-=command.length();
            }
            char currentChar =command.charAt(sum);
            output+=currentChar;
            command.deleteCharAt(sum);
        }
        System.out.println(output);


    }
}
