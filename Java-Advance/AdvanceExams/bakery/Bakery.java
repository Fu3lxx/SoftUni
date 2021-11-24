package AdvanceExams.bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void add(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }
    public boolean remove(String name){
        return this.employees.removeIf(e-> e.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        return this.employees.stream().sorted((e1,e2)-> Integer.compare(e2.getAge(), e1.getAge())).collect(Collectors.toList()).get(0);
    }
    public Employee getEmployee(String name){
        return employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:",this.name)).append(System.lineSeparator());
        for (var e:employees){
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
