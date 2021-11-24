package l1excerciseStatementsAndLoops;

import java.util.Scanner;

public class p5Login {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String log= scanner.nextLine();
        String password="";


        //System.out.println(passLength);

        for (int i = log.length()-1; i >=0 ; i--) {
            char currentSymbol=log.charAt(i);
            password += currentSymbol;
        }
        String pass= scanner.nextLine();
        int fail=0;

        while (!pass.equals(password)){
            fail++;
            if (fail==4){
                System.out.println("User "+log+" blocked!");
                break;
            }
            System.out.println("Incorrect password. Try again.");
            pass= scanner.nextLine();
        }
        if (pass.equals(password)){
            System.out.println("User "+log+" logged in.");
        }


    }
}
