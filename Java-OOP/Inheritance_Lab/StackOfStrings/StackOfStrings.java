package Inheritance_Lab.StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }
    public void push(String string){
        this.data.add(string);
    }
    public String pop(){
        return data.remove(data.size()-1);
    }
    public String peek(){
        return this.data.get(data.size()-1);
    }
    public boolean isEmpty(){
        if (this.data.isEmpty()){
            return true;
        }
        return false;
    }
}
