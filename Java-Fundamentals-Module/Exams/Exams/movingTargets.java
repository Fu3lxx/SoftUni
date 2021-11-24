package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class movingTargets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targetList= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] token = input.split(" ");

            String command =token[0];
            int index = Integer.parseInt(token[1]);
            int secondNum= Integer.parseInt(token[2]);

            switch (command){
                case "Shoot":
                    if (index>=0 && targetList.size()-1>=index){
                        targetList.set(index,targetList.get(index)-secondNum);
                        if (targetList.get(index)<=0){
                            targetList.remove(index);
                        }
                    } break;
                case "Add":
                    if (index>=0 && targetList.size()  > index){
                        targetList.add(index,secondNum);
                    }else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index-secondNum < 0 || index+secondNum > targetList.size()){
                        System.out.println("Strike missed!");
                    }
                    else {
                        for (int i = index+secondNum; i >=index-secondNum ; i--) {
                            targetList.remove(i);

                        }
                    }
            }


            input= scanner.nextLine();
        }
        int counter = 0;
        for (int number : targetList) {
            counter++;
            if (counter == targetList.size()) {
                System.out.print(number);
            } else {

                System.out.print(number + "|");
            }
        }
    }
}
