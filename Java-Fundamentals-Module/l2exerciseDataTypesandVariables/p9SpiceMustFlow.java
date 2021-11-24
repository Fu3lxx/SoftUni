package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p9SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int mined=0;
        int days=0;

        while (yield>=100){
            mined+=yield-26;
            yield-=10;
            days++;
        }
        mined-=26;
        if (mined<0){
            mined=0;
        }
        System.out.printf("%d\n%d",days,mined);
    }
}
