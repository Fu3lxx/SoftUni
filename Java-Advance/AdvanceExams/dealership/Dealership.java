package AdvanceExams.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {

    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car){
        if (capacity >data.size()){
            this.data.add(car);
        }
    }
    public boolean buy(String manufacturer,String model){
        return data.removeIf(e-> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model));
    }
    public Car getLatestCar(){
        return data.stream().sorted((a1,a2)-> Integer.compare(a2.getYear(), a1.getYear())).collect(Collectors.toList()).get(0);
    }
    public Car getCar(String manufacturer, String model){
       return data.stream().filter(c1-> c1.getManufacturer().equals(manufacturer) && c1.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:",this.name)).append(System.lineSeparator());
        for (var car:data){
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
