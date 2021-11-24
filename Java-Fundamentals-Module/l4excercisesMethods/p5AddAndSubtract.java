package l4excercisesMethods;

import java.util.Scanner;

public class p5AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        System.out.println(subtractMethod(first,second,third));

    }
    public static int sumOfFirstTwo (int first , int second){
        return first+second;
    }
    public static  int subtractMethod (int fist , int second , int third){
        //int sum = sumOfFirstTwo(fist,second);
        return sumOfFirstTwo(fist,second)-third;
    }

}
