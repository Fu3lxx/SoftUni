package DefiningClasses.Lab.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;


    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setHordePower(int horsePower){
        this.horsePower = horsePower;
    }
    public int getHorsePower() {
        return horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),this.getHorsePower());
    }
}
