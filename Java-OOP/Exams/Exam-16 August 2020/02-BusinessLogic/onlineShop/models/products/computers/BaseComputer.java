package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()){
            return super.getOverallPerformance();
        }else {
            double componentsPerformance = components.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0);
            return super.getOverallPerformance() + componentsPerformance;
        }
    }

    @Override
    public double getPrice() {
        double allComponents = components.stream().mapToDouble(Product::getPrice).sum();
        double allPeripherals = peripherals.stream().mapToDouble(Product::getPrice).sum();

        return super.getPrice() + allComponents + allPeripherals;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.contains(component)){
            throw new IllegalArgumentException
                    (String.format(EXISTING_COMPONENT,component.getClass().getSimpleName(),this.getClass().getSimpleName(),this.getId()));
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (components.isEmpty() || components.stream().noneMatch(component -> component.getClass().getSimpleName().equals(componentType))){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,componentType,this.getClass().getSimpleName(),this.getId()));
        }
        Component component = components.stream().filter(comp-> comp.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);
        components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(per-> per.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))){
            throw new IllegalArgumentException
                    (String.format(EXISTING_PERIPHERAL,peripheral.getClass().getSimpleName(),this.getClass().getSimpleName(),this.getId()));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = peripherals.stream().filter(per-> per.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);

        if (peripherals.isEmpty() || peripheral == null){
            throw new IllegalArgumentException
            (String.format(NOT_EXISTING_PERIPHERAL,peripheralType,this.getClass().getSimpleName(),this.getId()));
        }
        peripherals.remove(peripheral);
        return peripheral;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(PRODUCT_TO_STRING,
                getOverallPerformance(),getPrice(),this.getClass().getSimpleName(),getManufacturer(),getModel(),getId()))
                .append(System.lineSeparator());

        builder.append(String.format(COMPUTER_COMPONENTS_TO_STRING,components.size())).append(System.lineSeparator());
        for (var component:components){
            builder.append("  ").append(component.toString()).append(System.lineSeparator());
        }

        double average = peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0);
        builder.append(String.format(COMPUTER_PERIPHERALS_TO_STRING,peripherals.size(),average)).append(System.lineSeparator());
        for (var peripheral:peripherals){
            builder.append("  ").append(peripheral.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
