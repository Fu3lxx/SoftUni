package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class manOwar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> pirateShipList= Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        List <Integer> warShipList = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        int maxSecHealth=Integer.parseInt(scanner.nextLine());
        String input =scanner.nextLine();
        boolean anyDead=false;

        while (!input.equals("Retire")){

            String [] token = input.split(" ");

            if (token[0].equals("Fire")){
                int index = Integer.parseInt(token[1]);
                int damage = Integer.parseInt(token[2]);
                if (index>warShipList.size()-1 || index<0){
                    input= scanner.nextLine();
                    continue;
                }
                else {
                    int currentHealth= warShipList.get(index);
                    warShipList.set(index,currentHealth-damage);
                    if (warShipList.get(index) <= 0){
                        System.out.println("You won! The enemy ship has sunken.");
                        anyDead=true;
                        break;
                    }
                }
            }

            else if (token[0].equals("Defend")){
                int startIndex = Integer.parseInt(token[1]);
                int endIndex = Integer.parseInt(token[2]);
                int damage = Integer.parseInt(token[3]);
                if (startIndex>pirateShipList.size()-1 || startIndex<0 || endIndex>pirateShipList.size()-1 || endIndex<0){
                    input= scanner.nextLine();
                    continue;
                }
                else {
                    for (int i = startIndex; i <=endIndex ; i++) {
                        int currentHealth =pirateShipList.get(i);
                        pirateShipList.set(i,currentHealth-damage);
                        if (pirateShipList.get(i)<=0){
                            System.out.println("You lost! The pirate ship has sunken.");
                            anyDead=true;
                            break;
                        }
                    }
                }
            }

            else if (token[0].equals("Repair")){
                int index = Integer.parseInt(token[1]);

                if (index>pirateShipList.size()-1 || index<0){
                    input= scanner.nextLine();
                    continue;
                }
                int health = Integer.parseInt(token[2]);
                int currentHealth=pirateShipList.get(index);
                if (currentHealth+health>=maxSecHealth){
                    pirateShipList.set(index,maxSecHealth);
                }
                else {
                    pirateShipList.set(index,currentHealth+health);
                }
            }

            else if (token[0].equals("Status")){
                int sectionForRep = 0;
                for (int i = 0; i <pirateShipList.size() ; i++) {
                    double percent = 1.0*pirateShipList.get(i) /maxSecHealth *100;
                    if (percent<20){
                        sectionForRep++;
                    }
                }
                System.out.println(sectionForRep + " sections need repair.");
            }




            input= scanner.nextLine();
        }
        if (!anyDead){
            int pirateShitPoints = 0;
            int warShipPoints = 0;
            for (int i = 0; i <pirateShipList.size() ; i++) {
                pirateShitPoints+=pirateShipList.get(i);
            }
            for (int i = 0; i <warShipList.size() ; i++) {
                warShipPoints+=warShipList.get(i);
            }
            System.out.println("Pirate ship status: " + pirateShitPoints);
            System.out.println("Warship status: " + warShipPoints);
        }

    }
}
