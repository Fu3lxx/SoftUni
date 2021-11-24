package AdvanceExams.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void add(Rabbit rabbit){
        if (capacity > data.size()){
            this.data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name){
        return this.data.removeIf(r-> r.getName().equals(name));
    }
    public Rabbit sellRabbit(String name){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)){
                data.get(i).setAvailable(false);
                return data.get(i);
            }
        }
        return null;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> list = new ArrayList<>();
        for (int i = 0; i <data.size() ; i++) {
            if (data.get(i).getSpecies().equals(species)){
                list.add(data.get(i));
                data.get(i).setAvailable(false);
            }
        }
        return list;
    }
    public int count(){
        return this.data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:\n",this.name));
        for (var rabbit:data){
            if (rabbit.isAvailable()){
                sb.append(rabbit).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
