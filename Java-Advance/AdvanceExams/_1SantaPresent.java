package AdvanceExams;

import java.util.*;
import java.util.stream.Collectors;

public class _1SantaPresent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> toysData = new TreeMap<>();
        toysData.put("Doll",0);
        toysData.put("Wooden train",0);
        toysData.put("Teddy bear",0);
        toysData.put("Bicycle",0);

        ArrayDeque<Integer> materialsS = new ArrayDeque<>();
        ArrayDeque<Integer> magicQ = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(materialsS::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(magicQ::offer);

        boolean pearOfToy = false;
        while (!magicQ.isEmpty() || !materialsS.isEmpty()){
            if (magicQ.isEmpty() || materialsS.isEmpty() ){
                break;
            }
            int material = materialsS.peek();
            int magic = magicQ.peek();
            int result = material * magic;

            if (result < 0){
                magicQ.poll();
                materialsS.pop();
                materialsS.push(material + magic);
            }
            else if (material == 0 || magic == 0){
                if (material == 0){
                    materialsS.pop();
                }
                if (magic == 0){
                    magicQ.poll();
                }
            }
            else if (result == 150 || result == 250 || result == 300 || result ==400){
                magicQ.poll();
                materialsS.pop();
                switch (result){
                    case 150:
                        toysData.put("Doll",toysData.get("Doll") + 1);
                        break;
                    case 250:
                        toysData.put("Wooden train",toysData.get("Wooden train") + 1);
                        break;
                    case 300:
                        toysData.put("Teddy bear",toysData.get("Teddy bear") + 1);
                        break;
                    case 400:
                        toysData.put("Bicycle",toysData.get("Bicycle") + 1);
                        break;
                }
            }
            else {
                magicQ.poll();
                materialsS.pop();
                materialsS.push(material + 15);
            }
        }
        if (toysData.get("Doll") >0 && toysData.get("Wooden train") >0 || toysData.get("Teddy bear") > 0 && toysData.get("Bicycle") > 0){
            pearOfToy = true;
        }

        if (pearOfToy){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialsS.isEmpty()){
            System.out.println("Materials left: " + materialsS.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!magicQ.isEmpty()){
            System.out.println("Magic left: " + magicQ.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        for (var toy:toysData.entrySet()){
            if (toy.getValue() > 0){
                System.out.printf("%s: %d\n",toy.getKey(),toy.getValue());
            }
        }
    }
    /*Doll	150
      Wooden train	250
      Teddy bear	300
      Bicycle 	400
*/
}
