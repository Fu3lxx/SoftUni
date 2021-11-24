package finalExams.first;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3thePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String,String> pAndK = new TreeMap<>();
        Map <String, String> pAndC = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split("\\|");

            String piece = input[0];
            String composer = input[1];
            String key = input[2];


            pAndK.put(piece,key);
            pAndC.put(piece,composer);

        }

        String input;
        while (!"Stop".equals(input = scanner.nextLine())){
            String [] token = input.split("\\|");

            String command = token[0];
            String piece = token[1];

            switch (command){
                case "Add":
                    String composer = token[2];
                    String key = token[3];
                    if (!pAndC.containsKey(piece)){
                        pAndK.put(piece,key);
                        pAndC.put(piece,composer);
                        System.out.printf("%s by %s in %s added to the collection!\n",piece,composer,key);
                    }else {
                        System.out.printf("%s is already in the collection!\n",piece);
                    }
                    break;
                case "Remove":
                    if (pAndC.containsKey(piece)){
                        pAndC.remove(piece);
                        pAndK.remove(piece);
                        System.out.printf("Successfully removed %s!\n",piece);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;
                case "ChangeKey":
                    if (pAndK.containsKey(piece)){
                        pAndK.put(piece,token[2]);
                        System.out.printf("Changed the key of %s to %s!\n",piece,token[2]);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;
            }
        }

        pAndC.entrySet().forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s\n",e.getKey(),e.getValue(),pAndK.get(e.getKey())));
    }
}
