package l2labDataTypesAndVariables;

import java.util.Scanner;

public class p6CharsToString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String allCharacters="";
        for (int i = 0; i < 3; i++) {
            String currentSymbol= scanner.nextLine();
            allCharacters+=currentSymbol;
        }
        System.out.println(allCharacters);
    }
}
