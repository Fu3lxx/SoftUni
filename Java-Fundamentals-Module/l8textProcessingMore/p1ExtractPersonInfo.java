package l8textProcessingMore;

import java.util.Scanner;

public class p1ExtractPersonInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String text = scanner.nextLine();
            System.out.printf("%s is %s years old.\n",text.substring(text.indexOf("@")+1 , text.indexOf("|")),text.substring(text.indexOf("#") + 1 , text.indexOf("*")));
        }
    }
}
