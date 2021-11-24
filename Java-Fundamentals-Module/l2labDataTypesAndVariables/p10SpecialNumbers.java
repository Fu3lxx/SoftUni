package l2labDataTypesAndVariables;

import java.util.Scanner;

public class p10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {
            int digits=i;
            int sum=0;
            while (digits>0){
                int lastDigit=digits%10;
                sum+=lastDigit;
                digits=digits/10;
            }
            if (sum==5 || sum==7 || sum==11){
                System.out.println(i + " -> True");
            }
            else {
                System.out.println(i + " -> False");
            }
        }
    }
}
