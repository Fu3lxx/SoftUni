package l4excercisesMethods;

import java.util.Scanner;

public class p3CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();

        allCharacters(a,b);

    }
    public static  void allCharacters (String a , String b){
        char start =a.charAt(0);
        char edn =b.charAt(0);
        if (start<edn){
            for (int i = start+1; i < edn ; i++) {
                System.out.printf("%c ",i);
            }
        }else {
            for (int i = edn+1; i < start ; i++) {
                System.out.printf("%c ",i);
            }
        }


    }
}
