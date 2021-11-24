package AdvanceExams.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color,int capacity){
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor(){
        return this.color;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int count(){
        return data.size();
    }
    public void add(Present present){
        if (this.getCapacity() > data.size()){
            this.data.add(present);
        }
    }
    public boolean remove(String name){
        return data.removeIf(p -> p.getName().equals(name));
    }
    public Present heaviestPresent(){
        Present present2 = this.data.stream()
                .max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
        return present2;
    }
    public Present getPresent(String name){
        Present present2 = this.data.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
        return present2;
    }
    public String report(){
        StringBuilder str = new StringBuilder(String.format("%s bag contains:%n", this.getColor()));
        for (Present present : this.data) {
            str.append(present.toString()).append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
