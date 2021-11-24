package l5exerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p2ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] action =input.split(" ");
            int firstNum= Integer.parseInt(action[1]);
            if (action[0].equals("Delete")){
                for (int i = 0; i <list.size() ; i++) {
                    if (list.get(i).equals(firstNum)){
                        list.remove(i);
                        i--;
                    }
                }
            }if (action[0].equals("Insert")){
                list.add(Integer.parseInt(action[2]),Integer.parseInt(action[1]));
            }

            input= scanner.nextLine();
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
