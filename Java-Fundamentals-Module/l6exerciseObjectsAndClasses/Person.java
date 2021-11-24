package l6exerciseObjectsAndClasses;

public class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
