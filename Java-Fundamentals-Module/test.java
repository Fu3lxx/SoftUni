import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] tickets = scanner.nextLine().split("[\\s*,\\s+]");

        for (int i = 0; i <tickets.length ; i++) {

            if (tickets[i].length()==20){
                String ticket = tickets[i];

                String left = ticket.substring(0,10);
                String right = ticket.substring(10,20);

            }
        }



    }
}
