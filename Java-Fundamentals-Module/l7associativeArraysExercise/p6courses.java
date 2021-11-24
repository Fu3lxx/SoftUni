package l7associativeArraysExercise;

import java.util.*;

public class p6courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, List <String>> register = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String [] token = input.split(" : ");
            if (!register.containsKey(token[0])){
                register.put(token[0],new ArrayList<>());
            }
            register.get(token[0]).add(token[1]);

            input= scanner.nextLine();
        }

        register.entrySet().stream()
                .sorted((e1,e2)-> Integer.compare(e2.getValue().size(),e1.getValue().size()))
                .forEach(e ->{
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(student -> System.out.println("-- " + student));

        });

    }
}
