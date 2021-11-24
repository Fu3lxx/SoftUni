package exams;

import java.util.Arrays;
import java.util.Scanner;

public class muOnline {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        int health = 100;
        int bitcoins=0;
        int roomCount=0;
        boolean survived=true;
        String[] input=scanner.nextLine().split("\\|");

        for (int i = 0; i <input.length ; i++) {
            String[] action = input[i].split(" ");
            roomCount++;

            if (action[0].equals("potion")){

                if ((health + Integer.parseInt(action[1]))<= 100){
                    health+=Integer.parseInt(action[1]);
                    System.out.printf("You healed for %d hp.\n",Integer.parseInt(action[1]));
                }
                else  {
                    health+=Integer.parseInt(action[1]);
                    System.out.printf("You healed for %d hp.\n",100-(health-Integer.parseInt(action[1])));
                    health=100;
                }
                System.out.printf("Current health: %d hp.\n",health);
            }
            else if (action[0].equals("chest")){
                bitcoins+=Integer.parseInt(action[1]);
                System.out.printf("You found %d bitcoins.\n",Integer.parseInt(action[1]));
            }else {
                String mob = action[0];
                int damage = Integer.parseInt(action[1]);
                if (health>damage){
                    System.out.printf("You slayed %s.\n",mob);
                    health-=damage;
                }
                else {
                    System.out.printf("You died! Killed by %s.\nBest room: %d",mob,roomCount);
                    survived=false;
                    break;

                }
            }
        }
        if (survived){
            System.out.printf("You've made it!\nBitcoins: %d\nHealth: %d",bitcoins,health);
        }

    }
}
