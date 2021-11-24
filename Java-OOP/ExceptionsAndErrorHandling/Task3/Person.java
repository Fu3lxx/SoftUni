package ExceptionsAndErrorHandling.Task3;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public void setFirstName(String firstName) {
        if (firstName.isBlank()){
            throw new IllegalArgumentException("The first name cannot be empty");
        }else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName.isBlank()){
            throw new IllegalArgumentException("The last name cannot be empty");
        }else {
            this.lastName = lastName;
        }
    }

    public void setAge(int age) {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Age should be in rage [0 ... 120]");
        }
        else {
            this.age = age;
        }
    }
    private static boolean isBlank(String name){
        return name == null || name.trim().length() == 0;
    }
}
