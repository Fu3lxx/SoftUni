package l5exerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p6CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> fistPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List <Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (!fistPlayer.isEmpty() || !secondPlayer.isEmpty()){
            if (fistPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
            if (fistPlayer.get(0) >secondPlayer.get(0)){
                fistPlayer.add(fistPlayer.get(0));
                fistPlayer.add(secondPlayer.get(0));
                fistPlayer.remove(0);
                secondPlayer.remove(0);
            }
            else if (secondPlayer.get(0)>fistPlayer.get(0)){
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.add(fistPlayer.get(0));
                secondPlayer.remove(0);
                fistPlayer.remove(0);
            }
            else {
                fistPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }
        int sum=0;
        if (fistPlayer.size()>secondPlayer.size()){
            for (int i = 0; i <fistPlayer.size() ; i++) {
                sum+=fistPlayer.get(i);
            }
            System.out.printf("First player wins! Sum: %d",sum);
        }else {
            for (int i = 0; i <secondPlayer.size() ; i++) {
                sum+=secondPlayer.get(i);
            }
            System.out.printf("Second player wins! Sum: %d",sum);
        }

    }
}
