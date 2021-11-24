package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , String> emailsData = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equals("stop")){
            String email = scanner.nextLine();
            if (!email.contains("us") && !email.contains("uk") && !email.contains("com")){
                emailsData.put(name,email);
            }

            name = scanner.nextLine();
        }
        for (Map.Entry<String,String> email: emailsData.entrySet()){
            System.out.printf("%s -> %s\n",email.getKey(),email.getValue());
        }
    }
}
