package midExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <String> list = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Shop!")){
            String [] token =input.split("%");

            switch (token[0]){
                case "Important":
                    if (list.contains(token[1])){
                        list.remove(token[1]);
                        list.add(0,token[1]);
                    }
                    else {
                        list.add(0,token[1]);
                    }
                    break;
                case "Add":
                    if (!list.contains(token[1])){
                        list.add(token[1]);
                    }
                    else {
                        System.out.println("The product is already in the list.");
                    }
                    break;
                case "Swap":
                    if (list.contains(token[1])){
                        if (list.contains(token[2])){
                            int fistIndex = list.indexOf(token[1]);
                            int secondIndex =list.indexOf(token[2]);
                            String tmp = list.get(fistIndex);
                            list.set(fistIndex, list.get(secondIndex));
                            list.set(secondIndex, tmp);
                        }
                        else {
                            System.out.printf("Product %s missing!\n",token[2]);
                        }
                    }
                    else {
                        System.out.printf("Product %s missing!\n",token[1]);
                    }
                    break;
                case "Remove":
                    if (list.contains(token[1])){
                        list.remove(token[1]);
                    }
                    else {
                        System.out.printf("Product %s isn't in the list.\n",token[1]);
                    }
                    break;
                case "Reversed":
                    Collections.reverse(list);
                    break;
            }
            input= scanner.nextLine();
        }
        int counter = 1;
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n",counter,list.get(i));
            counter++;
        }
    }
}
