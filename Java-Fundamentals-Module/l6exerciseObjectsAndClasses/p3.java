package l6exerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            Person parameters = new Person(input[0], Integer.parseInt(input[1]));
            parameters.name=input[0];
            parameters.age=Integer.parseInt(input[1]);
            if (parameters.age>30){
                list.add(parameters);
            }
        }
        list.sort(Comparator.comparing(Person::getName));

        for (Person current : list){
            System.out.println(current.name + " - " + current.age);
        }
    }
}
