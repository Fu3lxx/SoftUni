package l2labDataTypesAndVariables;

import java.util.Scanner;

public class p2PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double pound=1.31;
        double dollar=Double.parseDouble(scanner.nextLine());

        System.out.printf("%.3f",dollar*1.0*pound);
    }
}
