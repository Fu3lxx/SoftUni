package InterfacesAndAbstraction_Lab._3and4;

public class European extends BasePerson implements Person{


    public European(String name) {
        super(name);

    }


    @Override
    public String sayHello() {
        return "Hello";
    }
}
