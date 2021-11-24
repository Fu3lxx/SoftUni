package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <String> list = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Stop!")){
            String [] token = input.split(" ");

            switch (token[0]){
                case "Join":
                    if (!list.contains(token[1])){
                        list.add(token[1]);
                    }
                    break;
                case "Drop":
                    if (list.contains(token[1])){
                        list.remove(token[1]);
                    }
                    break;
                case "Replace":
                    if (list.contains(token[1])){
                        if (!list.contains(token[2])){
                            int index =list.indexOf(token[1]);
                            list.add(index,token[2]);
                            list.remove(token[1]);
                        }
                    }
            }

            input= scanner.nextLine();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
