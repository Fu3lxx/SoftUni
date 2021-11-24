package exams;

import java.util.*;
import java.util.stream.Collectors;

public class treasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());


        String input=scanner.nextLine();
        while (!input.equals("Yohoho!")){

            String[] token =input.split(" ");

            if (token[0].equals("Loot")){
                int numberOfItems=token.length-1;
                for (int i = 1; i <=numberOfItems ; i++) {
                    if (!list.contains(token[i])){
                        list.add(0,token[i]);
                    }
                }
            }

            if (token[0].equals("Drop")){
                int index =Integer.parseInt(token[1]);
                if (index>list.size()-1|| index<0){
                    input=scanner.nextLine();
                    continue;
                }
                else {
                    String temp = list.get(index);
                    list.remove(index);
                    list.add(temp);
                }
            }

            if (token[0].equals("Steal")){
                int itemsToSteal =Integer.parseInt(token[1]);
                if (list.size()>itemsToSteal){
                    List<String> stealList = new ArrayList<>();
                    for (int i = 1; i <= itemsToSteal ; i++) {
                        String currentItem =list.get(list.size()-1);
                        stealList.add(currentItem);
                        list.remove(list.size()-1);
                    }
                    Collections.reverse(stealList);
                    System.out.println(String.join(", ",stealList));
                }
                else {

                    System.out.println(String.join(", ",list));
                    list.clear();
                }
            }


            input=scanner.nextLine();
        }
        if (list.size()==0){
            System.out.println("Failed treasure hunt.");
        }
        else {
            int allItemsLength=0;
            double listSize=list.size();
            for (int i = 0; i <list.size() ; i++) {
                allItemsLength+=list.get(i).length();
            }
            double averageTreasure= allItemsLength/listSize;
            System.out.printf("Average treasure gain: %.2f pirate credits.",averageTreasure);
        }
    }
}