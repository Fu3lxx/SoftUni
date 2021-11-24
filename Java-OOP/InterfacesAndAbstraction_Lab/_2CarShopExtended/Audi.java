package InterfacesAndAbstraction_Lab._2CarShopExtended;

public class Audi extends CarImpl implements Rentable{

    private Integer minRentPerDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced,Integer minRentPerDay,Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentPerDay = minRentPerDay;
        this.pricePerDay = pricePerDay;

    }

    @Override
    public Integer getMinRentDay() {
        return minRentPerDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s is %s color and have %s horse power", getModel(), getColor(), getHorsePower())).append(System.lineSeparator());
        sb.append(String.format("This is %s produced in %s and have %d tires", getModel(), countryProduced(),TIRES)).append(System.lineSeparator());
        sb.append(String.format("Minimum rental period of %d days. Price per day %f", getMinRentDay(),getPricePerDay()));
        return sb.toString();
    }

}
