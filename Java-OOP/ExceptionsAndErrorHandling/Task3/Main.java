package ExceptionsAndErrorHandling.Task3;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("pesho","Angelov",15);
            //Person person1 = new Person(" ","Angelov",15);
            //Person person2 = new Person("pesho","  ",15);
            Person person3 = new Person("pesho","Angelov",-5);

        }catch (IllegalArgumentException exception){
            System.out.println("Exception thrown: " + exception.getMessage());
        }
    }
}
