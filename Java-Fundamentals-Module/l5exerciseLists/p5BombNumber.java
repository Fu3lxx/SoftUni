package l5exerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p5BombNumber {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        List <Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] action= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bombNumber=action[0];
        int power=action[1];

        while (list.contains(bombNumber)){
            int indexOfBombNumber=list.indexOf(bombNumber);
            int leftBorder= Math.max(0,indexOfBombNumber-power);
            int rightBorder= Math.min(list.size()-1,indexOfBombNumber+power);

            for (int i = rightBorder; i >=leftBorder ; i--) {
                list.remove(i);
            }
        }
        int sum=0;
        for (int i = 0; i <list.size() ; i++) {
            sum+=list.get(i);
        }
        System.out.println(sum);
    }
}
