package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class arrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);
        List <Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] token = input.split(" ");
            String command = token[0];
            switch (command){
                case "swap":
                    int index1 = Integer.parseInt(token[1]);
                    int index2 = Integer.parseInt(token[2]);
                    int temp = list.get(index1);
                    list.set(index1,list.get(index2));
                    list.set(index2,temp);
                    break;
                case "multiply":
                    int index11 = Integer.parseInt(token[1]);
                    int index22 = Integer.parseInt(token[2]);
                    list.set(index11, list.get(index11) * list.get(index22));
                    break;
                case "decrease":
                    for (int i = 0; i < list.size() ; i++) {
                        list.set(i, list.get(i)-1);

                    }

            }


            input= scanner.nextLine();
        }
        for (int i = 0; i < list.size() ; i++) {
            if (i+1<list.size()){
                System.out.print(list.get(i)+", ");
            }
            else {
                System.out.print(list.get(i));
            }
        }
    }
}
