package InterfacesAndAbstraction_Lab._5BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> list = new ArrayList<>();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");

            if (data.length == 2){
                Robot robot = new Robot(data[0],data[1] );
                list.add(robot);
            }else {
                Citizen citizen = new Citizen(data[0],Integer.parseInt(data[1]),data[2]);
                list.add(citizen);
            }

            input = scanner.nextLine();
        }
        String endWith = scanner.nextLine();

        for (Identifiable id : list ){
            if (id.getId().endsWith(endWith)){
                System.out.println(id.getId());
            }
        }
    }
}
