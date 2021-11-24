package l6exerciseObjectsAndClasses;

import java.util.*;

public class p5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<StudentFirst> studentsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            StudentFirst currentStudent = new StudentFirst(data[0],data[1],Double.parseDouble(data[2]));
            studentsList.add(currentStudent);
        }
        studentsList.sort(Comparator.comparing(StudentFirst::getGrade));
        Collections.reverse(studentsList);


        for (StudentFirst current :studentsList){
            System.out.println(current.toString());
        }
    }
}
