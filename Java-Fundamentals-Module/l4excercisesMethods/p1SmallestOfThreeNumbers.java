package l4excercisesMethods;

import java.util.Scanner;

public class p1SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        System.out.println(findSmallestNum(a,b,c));

    }
    public  static  int findSmallestNum (int a, int b, int c){
        int smallest= Integer.MAX_VALUE;
        if (a<smallest){
            smallest=a;
        }if (b<smallest){
            smallest=b;
        }if (c<smallest){
            smallest=c;
        }
        return smallest;

    }
}
