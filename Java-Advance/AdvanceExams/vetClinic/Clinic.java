package AdvanceExams.vetClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (capacity > data.size()){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        for (Pet pet:data){
            if (pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner){
        for (Pet pet : data){
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    public Pet getOldestPet(){
        return this.data.stream().sorted((p1,p2) -> Integer.compare(p2.getAge(), p1.getAge())).collect(Collectors.toList()).get(0);
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet:data){
            sb.append(String.format("%s %s\n",pet.getName(),pet.getOwner()));
        }
        return sb.toString();
    }
}
