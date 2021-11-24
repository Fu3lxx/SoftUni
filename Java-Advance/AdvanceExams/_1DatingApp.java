package AdvanceExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesS = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQ = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(malesS::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(femalesQ::offer);
        int matches = 0;

        while (malesS.size() >0 || femalesQ.size() > 0){
            if (malesS.isEmpty() || femalesQ.isEmpty()){
                break;
            }
            int male = malesS.peek();
            int female = femalesQ.peek();
            if (male <= 0 || female <= 0){
                if (male <= 0){
                    malesS.pop();
                }
                else {
                    femalesQ.poll();
                }
            }
            else if (male % 25 == 0 || female % 25 == 0){
                if (female % 25 == 0){
                    femalesQ.poll();
                    femalesQ.poll();
                }

                if (male % 25 == 0){
                    malesS.pop();
                    malesS.pop();
                }
            }
            else if (male == female){
                matches++;
                malesS.pop();
                femalesQ.poll();
            }
            else {
                malesS.pop();
                femalesQ.poll();
                malesS.push(male - 2);

            }
        }
        System.out.println("Matches: " + matches);

        if (malesS.isEmpty()){
            System.out.println("Males left: none");
        }else {
            System.out.print("Males left: " + malesS.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (femalesQ.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.print("Females left: " + femalesQ.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }


    }
}
