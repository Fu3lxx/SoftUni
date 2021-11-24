package l6exerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();
        String data = scanner.nextLine();
        while (!data.equals("End")){
            String [] details =data.split("\\s+");
            Student currentStudent =new Student(details[0],Integer.parseInt(details[1]),Integer.parseInt(details[2]));
            studentList.add(currentStudent);
            data= scanner.nextLine();
        }
        studentList.sort(Comparator.comparing(Student::getAge));

        for (Student currentStudent : studentList){
            System.out.println(currentStudent.toString());
        }
    }
}
