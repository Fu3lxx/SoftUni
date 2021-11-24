package exams;

import java.util.*;
import java.util.stream.Collectors;

public class numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int totalSum=0;
        double averageNum=0;
        for (int i = 0; i <list.size() ; i++) {
            totalSum+=list.get(i);
        }
        averageNum=totalSum*1.0/list.size();
        List<Integer> greaterNum=new ArrayList<>();

        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i)*1.0>averageNum){
                greaterNum.add(list.get(i));
            }

        }
        Collections.sort(greaterNum);
        Collections.reverse(greaterNum);
        if (greaterNum.size()-1 >=5){
            for (int i = 0; i <5 ; i++) {
                System.out.print(greaterNum.get(i)+ " ");
            }
        }
        else if (greaterNum.size()>0 && greaterNum.size()<5) {
            for (int i = 0; i < greaterNum.size(); i++) {
                System.out.print(greaterNum.get(i) + " ");
            }
        }else {
            System.out.println("No");
        }
    }
}

