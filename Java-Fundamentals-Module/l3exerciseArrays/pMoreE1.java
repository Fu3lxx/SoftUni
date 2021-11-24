package l3exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class pMoreE1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] encryptNumbers=new int[n];

        for (int i = 0; i <n ; i++) {
            String name = scanner.nextLine();


            //проверка за гласни
            String vowel = "AaEeIiOoUu";
            boolean isVowel = false;
            int sumOfWord=0;
            for (int j = 0; j < name.length(); j++) {
                if (vowel.indexOf(name.charAt(j)) != -1) {
                    isVowel = true;
                }else {
                    isVowel=false;
                }
                if (isVowel){
                    int sum =(int) name.charAt(j)*name.length();
                    sumOfWord+=sum;
                } else {
                    int sum=(int) name.charAt(j) / name.length();
                    sumOfWord+=sum;
                }
            }
            //System.out.println(sumOfWord);

            encryptNumbers[i]=sumOfWord;

        }


        Arrays.sort(encryptNumbers);

        for (int i = 0; i <encryptNumbers.length ; i++) {
            System.out.println(encryptNumbers[i]);

        }

    }
}
