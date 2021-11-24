package Encapsulation_Exercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative number");
        }
        this.money = money;
    }
    public void buyProduct(Product product){
        if (product.getCost() <= this.money){
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n",this.name,product.getName());
            products.add(product);
        }else {
            String message = String.format("%s can't afford %s%n",this.name,product.getName());
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }
}
