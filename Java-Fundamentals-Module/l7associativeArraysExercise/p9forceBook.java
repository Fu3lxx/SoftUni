package l7associativeArraysExercise;

import java.util.*;

public class p9forceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String , List<String>> sides = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")){
            String [] token ;

            if (input.contains("|")){
                token= input.split(" \\| ");
                String force = token[0];
                String name = token[1];

                if (!sides.containsKey(force)){
                    sides.put(force,new ArrayList<>());
                    sides.get(force).add(name);
                }
                else if (sides.containsKey(force)){
                    if (!sides.get(force).contains(name)){
                        sides.get(force).add(name);
                    }
                }
            }
            else if (input.contains("->")){
                token = input.split(" -> ");
                String force = token[1];
                String name = token[0];

                boolean check = false;
                for (var entry : sides.entrySet()){
                    if (entry.getValue().contains(name)){
                        check = true;
                    }
                }
                if (!check){
                    if (sides.containsKey(force)){
                        sides.get(force).add(name);
                        System.out.printf("%s joins the %s side!\n",name,force);
                    }
                    else {
                        sides.put(force,new ArrayList<>());
                        sides.get(force).add(name);
                        System.out.printf("%s joins the %s side!\n",name,force);
                    }
                }
                if (check){
                    for (var entry :sides.entrySet()){
                        if (entry.getValue().contains(name)){
                            sides.get(entry.getKey()).remove(name);
                            if (sides.containsKey(force)){
                                sides.get(force).add(name);
                                System.out.printf("%s joins the %s side!\n",name,force);
                            }else {
                                sides.put(force,new ArrayList<>());
                                sides.get(force).add(name);
                                System.out.printf("%s joins the %s side!\n",name,force);
                            }
                        }
                    }
                }
            }



            input = scanner.nextLine();
        }
        sides
                .entrySet()
                .stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());

                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });

    }
}
