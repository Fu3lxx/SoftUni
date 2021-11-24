package finalExams.first;

import java.util.Scanner;

public class p1secretChat {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        String input =scanner.nextLine();
        while (!input.equals("Reveal")){
            String [] token = input.split(":\\|:");
            String command = token[0];

            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(token[1]);
                    sb.append(text);
                    sb.insert(index," ");
                    text=sb.toString();
                    sb.setLength(0);
                    System.out.println(text);
                    break;

                case "Reverse":
                    String sub = token[1];
                    if (text.contains(sub)){
                        StringBuilder reverse = new StringBuilder(sub).reverse();
                        text=text.replaceFirst(sub,"");
                        sb.append(text).append(reverse);
                        text=sb.toString();
                        sb.setLength(0);
                        System.out.println(text);
                    }
                    else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String target =token[1];
                    String replacement = token[2];
                    text=text.replace(target,replacement);
                    System.out.println(text);
                    break;
            }

            input= scanner.nextLine();
        }
        System.out.println("You have a new text message: "+text);

    }
}
