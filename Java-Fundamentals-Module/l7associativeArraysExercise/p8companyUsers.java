package l7associativeArraysExercise;

import java.util.*;

public class p8companyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, List<String>> register = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")){
            String [] token = input.split(" -> ");
            String company = token[0];
            String id =token[1];

            if (!register.containsKey(company)){
                register.put(company,new ArrayList<>());
                register.get(company).add(id);
            }
            else {
                if (!register.get(company).contains(id)){
                    register.get(company).add(id);
                }
            }

            input = scanner.nextLine();
        }
        for (var entry : register.entrySet()){
            System.out.println(entry.getKey());
            for (String id : entry.getValue()){
                System.out.println("-- " + id);
            }
        }
    }
}
