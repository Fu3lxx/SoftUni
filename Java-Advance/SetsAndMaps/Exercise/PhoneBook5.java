package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String,String> phonebook = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.put(name,number);
            input= scanner.nextLine();
        }

        String searchByName = scanner.nextLine();
        while (!searchByName.equals("stop")){
            if (phonebook.containsKey(searchByName)){
                System.out.printf("%s -> %s\n",searchByName,phonebook.get(searchByName));
            }
            else {
                System.out.printf("Contact %s does not exist.\n",searchByName);
            }

            searchByName= scanner.nextLine();
        }
    }
}
