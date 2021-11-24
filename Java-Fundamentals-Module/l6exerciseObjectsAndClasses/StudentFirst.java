package l6exerciseObjectsAndClasses;

public class StudentFirst {
    String firstName;
    String lastName;
    double grade;

    public StudentFirst(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f",firstName,lastName,grade);
    }

}
