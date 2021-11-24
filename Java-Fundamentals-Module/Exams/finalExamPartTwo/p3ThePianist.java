package finalExamPartTwo;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String,String> pieceComposer = new TreeMap<>();
        Map <String,String> pieceKey = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            String [] arr = scanner.nextLine().split("\\|");
            String piece = arr[0];
            String composer = arr[1];
            String key = arr[2];

            pieceComposer.put(piece,composer);
            pieceKey.put(piece,key);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            String [] token = input.split("\\|");
            String command = token[0];
            String piece = token[1];

            switch (command){
                case "Add":
                    if (!pieceComposer.containsKey(piece)){
                        String composer = token[2];
                        String key = token[3];
                        pieceComposer.put(piece,composer);
                        pieceKey.put(piece,key);
                        System.out.printf("%s by %s in %s added to the collection!\n",piece,composer,key);
                    }
                    else {
                        System.out.printf("%s is already in the collection!\n",piece);
                    }
                    break;

                case "Remove":
                    if (pieceComposer.containsKey(piece)){
                        System.out.printf("Successfully removed %s!\n",piece);
                        pieceComposer.remove(piece);
                        pieceKey.remove(piece);
                    }
                    else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;

                case "ChangeKey":
                    String newKey = token[2];
                    if (pieceKey.containsKey(piece)){
                        pieceKey.put(piece,newKey);
                        System.out.printf("Changed the key of %s to %s!\n",piece,newKey);
                    }
                    else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
            }

            input = scanner.nextLine();
        }

        pieceComposer.entrySet().stream().forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s\n",e.getKey(),e.getValue(),pieceKey.get(e.getKey())));
    }
}
