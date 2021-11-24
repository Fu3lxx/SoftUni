package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String reservationList = scanner.nextLine();
        while (!reservationList.equals("PARTY")){
            if (isVip(reservationList)){
                vip.add(reservationList);
            }
            else {
                regular.add(reservationList);
            }
            reservationList = scanner.nextLine();
        }

        String comingList = scanner.nextLine();
        while (!comingList.equals("END")){
            if (isVip(comingList)){
                vip.remove(comingList);
            }
            else {
                regular.remove(comingList);
            }
            comingList = scanner.nextLine();
        }
        int totalSize = vip.size() + regular.size();
        System.out.println(totalSize);
        for (var vipPpl : vip){
            System.out.println(vipPpl);
        }
        for (var regularPpl : regular){
            System.out.println(regularPpl);
        }
    }

    private static boolean isVip(String reservationList) {
        return Character.isDigit(reservationList.charAt(0));
    }
}
