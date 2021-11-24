package DefiningClasses.Exercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList <T extends Comparable<T>>{
    private List<T> list;

    public CustomList(){
        this.list= new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }
    public void remove(int index){
        if (validateIndex(index)){
            this.list.remove(index);
        }
    }
    public boolean contains(T element){
        return this.list.contains(element);
    }
    public void swap(int index1, int index2){

        if (validateTwoIndexes(index1,index2)){
            T first = this.list.get(index1);
            T second = this.list.get(index2);

            this.list.set(index1,second);
            this.list.set(index2,first);
        }
    }
    public int greater(T element){
        int counter = 0;
        for (T el:list){
            if (el.compareTo(element) > 0){
                counter++;
            }
        }
        return counter;
    }
    public T max(){
        T max = null;
        for (T value : list) {
            if (max == null || value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }
    public T min(){
        T min = null;
        for (T value : this.list) {
            if (min == null || value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T el:this.list){
            sb.append(el);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    private boolean validateTwoIndexes(int firstIndex, int secondIndex) {
        return firstIndex >= 0 && firstIndex < this.list.size()
                && secondIndex >= 0 && secondIndex < this.list.size();
    }
    private boolean validateIndex(int index) {
        return index >= 0 && index < this.list.size();
    }
    public void sort(){
        this.list = this.list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}