package l5moreExerciseLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class takeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> digits = input.chars().mapToObj(c -> (char)c).filter(Character::isDigit).map(ch -> ch - '0').collect(Collectors.toList());
        List<Character> notDigits = input.chars().mapToObj(c -> (char)c).filter(ch -> !Character.isDigit(ch)).collect(Collectors.toList());
        List<Character> finalText = new ArrayList<>();
        int currentIndex =0;
        for (int i = 0; i < digits.size(); i++) {
            int times = digits.get(i);

            if (i % 2 == 0){ //take list
                if (digits.get(i)!=0){
                    for (int j = 0; j < times; j++) {
                        if (notDigits.size()==0){
                            break;
                        }
                        finalText.add(notDigits.get(0));
                        notDigits.remove(0);
                    }

                }

            }
            if (i % 2 == 1){  //skip list
                if (notDigits.size()==0){
                    break;
                }
                if (digits.get(i) != 0){
                    for (int j = 0; j < times  ; j++) {

                        notDigits.remove(0);
                    }
                }
            }
        }

        for (int i = 0; i <finalText.size() ; i++) {
            System.out.print(finalText.get(i));
        }

    }
}
