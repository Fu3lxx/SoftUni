package l7associativeArraysExercise;

import java.util.*;

public class p7studentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String , List<Double>> grades = new LinkedHashMap<>();
        Map <String,Double> averageGrades = new TreeMap<>();

        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <times ; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());
            if (!grades.containsKey(name)){
                grades.put(name,new ArrayList<>());
            }
            grades.get(name).add(grade);
        }

        for (var entry : grades.entrySet()){
            double average = entry.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
            if (average >= 4.5){
                averageGrades.put(entry.getKey(),average);
            }
        }
        averageGrades.entrySet().stream()
                .sorted((g1,g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.printf("%s -> %.2f\n",grade.getKey(),grade.getValue());
                });
    }
}
