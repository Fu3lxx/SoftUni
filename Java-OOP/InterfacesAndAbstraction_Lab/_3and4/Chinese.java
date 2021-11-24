package InterfacesAndAbstraction_Lab._3and4;

public class Chinese extends BasePerson implements Person{


    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
