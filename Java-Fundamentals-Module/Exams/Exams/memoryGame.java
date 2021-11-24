package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class memoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        int moves=0;
        while (!input.equals("end")){

            if (list.size()==0){
                break;
            }



            String [] token = input.split(" ");
            int firstIndex =Integer.parseInt(token[0]);
            int secondIndex = Integer.parseInt(token[1]);


            if (firstIndex<0 || firstIndex>list.size()-1 || secondIndex< 0 || secondIndex> list.size()-1){
                System.out.println("Invalid input! Adding additional elements to the board");

                    int middleIndex= list.size()  /2;
                    moves++;
                    list.add(middleIndex,"-"+moves+"a");
                    list.add(middleIndex,"-"+moves+"a");
                    input= scanner.nextLine();

                    continue;
            }


            if (list.get(firstIndex).equals(list.get(secondIndex))){
                System.out.printf("Congrats! You have found matching elements - %s!\n",list.get(firstIndex));
                String currentSymbol=list.get(firstIndex);
                list.remove(currentSymbol);
                list.remove(currentSymbol);
                moves++;
            }
            else {
                System.out.println("Try again!");
            }




            input= scanner.nextLine();
        }
        if (list.size()==0){
            System.out.printf("You have won in %d turns!",moves);
        }
        else {
            System.out.println("Sorry you lose :(");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
