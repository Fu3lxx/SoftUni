package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class hearthDeliveryNotComplete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
        int lastIndex=0;
        while (true){
            String input = scanner.nextLine();
            if (input.equals("Love!")){
                break;
            }
            String[] splitLine=input.split(" ");
           int jumpIndex= Integer.parseInt(splitLine[1]);
           lastIndex+=jumpIndex;

           if (lastIndex>= list.size()){
               lastIndex=0;
           }

           if (jumpIndex<list.size()&& jumpIndex>=0){
               if (lastIndex<list.size()){
                   if (list.get(lastIndex)==0){
                       System.out.printf("Place %d already had Valentine's day.\n",lastIndex);
                   }
                   else {
                       list.set(lastIndex,list.get(lastIndex) - 2);
                       if (list.get(lastIndex)==0){
                           System.out.printf("Place %d has Valentine's day.\n", lastIndex);
                       }
                   }
               }


           }
        }
    }
}
