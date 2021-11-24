package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p12Snowballs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        int bestSnow=0;
        int bestTime=0;
        int bestQ=0;
        double bestScore = Double.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int ballSnow=Integer.parseInt(scanner.nextLine());
            int ballTime=Integer.parseInt(scanner.nextLine());
            int ballQuality = Integer.parseInt(scanner.nextLine());

            double snowBallQ=Math.pow(ballSnow*1.0/ballTime,ballQuality);
            //System.out.println(snowBallQ);
            if (snowBallQ>bestScore){
                bestScore=snowBallQ;
                bestSnow=ballSnow;
                bestTime=ballTime;
                bestQ=ballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",bestSnow,bestTime,bestScore,bestQ);


    }
}
