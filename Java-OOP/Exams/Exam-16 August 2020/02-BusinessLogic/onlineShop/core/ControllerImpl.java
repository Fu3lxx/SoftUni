package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.*;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Map<Integer,Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        computers = new HashMap<>();
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    private void checkComputerId(int id){
        if (!computers.containsKey(id)){
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

    }
    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;
        if (computerType.equals("Laptop")){
            computer = new Laptop(id,manufacturer,model,price);
        }else if (computerType.equals("DesktopComputer")){
            computer = new DesktopComputer(id,manufacturer,model,price);
        }else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        if (computers.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        computers.put(id,computer);
        return String.format(ADDED_COMPUTER,id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        checkComputerId(computerId);
        Peripheral peripheral;
        if (peripherals.stream().anyMatch(peripheral1 -> peripheral1.getId() == id)){
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        if (peripheralType.equals("Headset")){
            peripheral = new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
        }else if (peripheralType.equals("Keyboard")){
            peripheral = new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);
        }else if (peripheralType.equals("Monitor")){
            peripheral = new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);
        }else if (peripheralType.equals("Mouse")){
            peripheral = new Mouse(id,manufacturer,model,price,overallPerformance,connectionType);
        }else {
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        if (peripherals.contains(peripheral)){
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }



        computers.get(computerId).addPeripheral(peripheral);
        peripherals.add(peripheral);

        return String.format(ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkComputerId(computerId);
        Peripheral peripheral =
                peripherals.stream().filter(peripheral1 -> peripheral1.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);

        computers.get(computerId).removePeripheral(peripheralType);
        peripherals.remove(peripheral);
        return String.format(REMOVED_PERIPHERAL,peripheralType,peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        checkComputerId(computerId);
        Component component;
        if (componentType.equals("CentralProcessingUnit")){
            component = new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
        }else if (componentType.equals("Motherboard")){
            component = new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
        }else if (componentType.equals("PowerSupply")){
            component = new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
        }else if (componentType.equals("RandomAccessMemory")){
            component = new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);
        }else if (componentType.equals("SolidStateDrive")){
            component = new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);
        }else if (componentType.equals("VideoCard")){
            component = new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
        } else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        if (components.stream().anyMatch(component1 -> component1.getId() == id)){
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        computers.get(computerId).addComponent(component);
        components.add(component);

        return String.format(ADDED_COMPONENT,componentType,id,computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        checkComputerId(computerId);

        computers.get(computerId).removeComponent(componentType);
        Component component = components.stream().filter(component1 -> component1.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);
        components.remove(component);

        return String.format(REMOVED_COMPONENT,componentType,component.getId());
    }

    @Override
    public String buyComputer(int id) {
        checkComputerId(id);
        Computer computer = computers.get(id);
        computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = computers.values().stream().sorted(Comparator.comparing(Product::getOverallPerformance).reversed()).filter(comp -> comp.getPrice() <= budget).findFirst().orElse(null);
        if (computer == null){
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));
        }
        computers.remove(computer.getId());
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        checkComputerId(id);

        return computers.get(id).toString();
    }
}
