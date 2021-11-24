package stackAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Integer> nameTime = new LinkedHashMap<>();
        Map<String , Integer> nameWorkTime = new LinkedHashMap<>();
        ArrayDeque <String> queue = new ArrayDeque<>();

        String [] data = scanner.nextLine().split(";");
        for (String robots:data){
            String name = robots.split("-")[0];
            int time = Integer.parseInt(robots.split("-")[1]);
            nameTime.put(name,time);
            nameWorkTime.put(name,0);
        }

        String time = scanner.nextLine();
        int timeInSec = secMaker(time);

        String input = scanner.nextLine();
        while (!input.equals("End")){
            queue.offer(input);
            input= scanner.nextLine();
        }

        while (!queue.isEmpty()){
            String currentProduct = queue.poll();
            timeInSec++;
            decreaseWorkingTime(nameWorkTime);
            boolean isTaken = false;
            for (var robot:nameWorkTime.entrySet()){
                int timeToComplete = nameTime.get(robot.getKey());
                if (robot.getValue() == 0){
                    System.out.println(robot.getKey() + " - " + currentProduct + " "+ formattedTime(timeInSec));
                    nameWorkTime.put(robot.getKey(),nameTime.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken){
                queue.offer(currentProduct);
            }
        }

    }

    private static void decreaseWorkingTime(Map<String, Integer> nameWorkTime) {
        for (var robot :nameWorkTime.entrySet()){
            if (robot.getValue() > 0){
                nameWorkTime.put(robot.getKey(),robot.getValue() - 1);
            }
        }
    }

    private static String formattedTime(int timeInSec) {
        int hour = timeInSec / 3600 %24;
        int min = timeInSec % 3600 / 60;
        int sec = timeInSec % 60;

        return String.format("[%02d:%02d:%02d]",hour,min,sec);

    }

    private static int secMaker(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt(time.split(":")[2]);
        return hour * 3600 + minutes * 60 + sec;
    }
}
