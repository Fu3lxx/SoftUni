package l1lLabBasicSyntaxConditionStatementsAndLoops;

import java.util.Scanner;

public class p6ForeignLanguage {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String country= scanner.nextLine();

        switch (country){
            case "USA":
            case "England":
                System.out.println("English");
                break;
            case "Spain":
            case "Mexico":
            case "Argentina":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
        }
    }
}
