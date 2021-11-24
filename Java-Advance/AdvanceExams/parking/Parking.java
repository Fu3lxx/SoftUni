package AdvanceExams.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type,int capacity){
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car){
        if (capacity > data.size()){
            data.add(car);
        }
    }
    public boolean remove(String manufacturer,String model){
        for (Car car:data){
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                data.remove(car);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar(){
        if (data.isEmpty()){
            return null;
        }
        return data.stream().sorted((c1,c2) -> Integer.compare(c2.getYear(), c1.getYear())).collect(Collectors.toList()).get(0);
    }
    public Car getCar(String manufacturer,String model){
        for (Car car:data){
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:\n",type));
        for (Car car:data){
            sb.append(String.format("%s %s (%s)\n",car.getManufacturer(),car.getModel(),car.getYear()));
        }
        return sb.toString();
    }

}
