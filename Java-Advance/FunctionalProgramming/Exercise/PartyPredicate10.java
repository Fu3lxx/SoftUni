package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartyPredicate10 {

    static List<String> names = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!line.equals("Party!")){
            String [] token = line.split("\\s+");

            switch (token[0]){
                case "Double":
                    addOneMore(getPredicate(token));
                    break;
                case "Remove":
                    removeName(getPredicate(token));
                    break;
            }

            line = scanner.nextLine();
        }
        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }
        else {
            Collections.sort(names);
            System.out.println(names.toString().replaceAll("[\\[\\]]","") + " are going to the party!");
        }
    }

    private static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate) {
        List<String> nameToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(nameToAdd::add);
        names.addAll(nameToAdd);
    }

    public static Predicate<String> getPredicate(String[] tokens){
        Predicate<String> predicate = null;

        if (tokens[1].equals("StartsWith")){
            predicate = name -> name.startsWith(tokens[2]);
        }
        else if (tokens[1].equals("EndsWith")){
            predicate = name -> name.endsWith(tokens[2]);
        }
        else {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }
        return predicate;
    }

}
