package AdvanceExams.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet){
        if (capacity > data.size()){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(r-> r.getName().equals(name));
    }
    public Pet getPet(String name, String owner){
        return this.data.stream().filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner)).findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (var pet:data){
            sb.append(String.format("%s %s\n",pet.getName(),pet.getOwner()));
        }
        return sb.toString().trim();
    }



}
