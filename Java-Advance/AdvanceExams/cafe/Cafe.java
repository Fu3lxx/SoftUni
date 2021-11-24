package AdvanceExams.cafe;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name,int capacity){
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        return this.employees.removeIf(r-> r.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        return this.employees.stream().sorted((e1,e2) -> Integer.compare(e2.getAge(), e1.getAge())).collect(Collectors.toList()).get(0);
    }
    public Employee getEmployee(String name){
        return this.employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
        /*for (var employee:employees){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
         */
    }
    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:\n",this.name));
        for (var employee:employees){
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
