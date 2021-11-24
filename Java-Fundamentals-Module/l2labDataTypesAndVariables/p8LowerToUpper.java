package l2labDataTypesAndVariables;

import java.util.Scanner;

public class p8LowerToUpper {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        char currentSymbol=scanner.nextLine().charAt(0);

        int number=(int) currentSymbol ;

        //System.out.println(number);

        if (number>=41 &&number<=90){
            System.out.println("upper-case");
        }
        if (number >= 97 && number <= 122){
            System.out.println("lower-case");
        }

    }
}
