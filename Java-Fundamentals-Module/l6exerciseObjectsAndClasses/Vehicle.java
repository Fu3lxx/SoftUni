package l6exerciseObjectsAndClasses;

public class Vehicle {
    String type;
    String model;
    String color;
    int horsePower;

    public Vehicle(String type, String model, String color, int horsePower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type=type.replace(type.charAt(0),Character.toUpperCase(type.charAt(0)));
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }
    public String toString() {
        return String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %d",this.getType(),getModel(),getColor(),getHorsePower());
    }

}
