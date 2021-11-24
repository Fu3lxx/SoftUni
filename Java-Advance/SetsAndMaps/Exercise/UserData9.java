package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserData9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String,LinkedHashMap<String,Integer>> userData = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] data = input.split("\\s+");
            String user = data[2].split("=")[1];
            String ip = data[0].split("=")[1];
            String message = data[1].split("=")[1];

            userData.putIfAbsent(user,new LinkedHashMap<>());
            userData.get(user).putIfAbsent(ip,0);
            userData.get(user).put(ip,userData.get(user).get(ip) + 1);

            input= scanner.nextLine();
        }

        userData.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": ");
            int countEntry = entry.getValue().size();
            for (var ipEntry : entry.getValue().entrySet()){
                if (countEntry > 1){
                    System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue() + ", ");
                }
                else {
                    System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue() + ". ");
                }
                countEntry--;
            }
            System.out.println();
        });
    }
}
