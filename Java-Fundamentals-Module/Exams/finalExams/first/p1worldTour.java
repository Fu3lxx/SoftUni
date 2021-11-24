package finalExams.first;

import java.util.Scanner;

public class p1worldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tour = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        String input = scanner.nextLine();
        while (!input.equals("Travel")){

            if (input.contains("Add Stop")){
                String [] token = input.split(":");
                int index = Integer.parseInt(token[1]);
                String add = token[2];

                if (index>=0 && index<tour.length()){
                    sb.append(tour);
                    sb.insert(index,add);

                    tour=sb.toString();
                    sb.setLength(0);
                }
                System.out.println(tour);
            }
            else if (input.contains("Remove Stop")){
                String [] token = input.split(":");
                int startIndex = Integer.parseInt(token[1]);
                int endIndex = Integer.parseInt(token[2]);

                if (startIndex >= 0 && startIndex < tour.length() && endIndex >= 0 && endIndex < tour.length()){
                    sb.append(tour);
                    sb.replace(startIndex,endIndex+1,"");
                    tour=sb.toString();
                    sb.setLength(0);
                }
                System.out.println(tour);
            }
            else if (input.contains("Switch:")){
                String [] token = input.split(":");
                String target = token[1];
                String replacement = token[2];

                if (tour.contains(target)){
                    tour=tour.replace(target,replacement);
                }
                System.out.println(tour);
            }
            input= scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + tour);
    }
}
