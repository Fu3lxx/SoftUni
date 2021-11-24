package l6exerciseObjectsAndClasses;

public class Student {
    String name;
    int id;
    int age;

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString(){
        return String.format("%s with ID: %d is %d years old.",getName(),getId(),getAge());
    }

}
