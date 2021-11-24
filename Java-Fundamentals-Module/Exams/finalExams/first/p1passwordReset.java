package finalExams.first;

import java.util.Scanner;

public class p1passwordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String pass = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String [] token = input.split(" ");

            if (token[0].equals("TakeOdd")){
                for (int i = 0; i <pass.length() ; i++) {
                    if (i % 2 !=0){
                        sb.append(pass.charAt(i));
                    }
                }
                pass=sb.toString();
                sb.setLength(0);
                System.out.println(pass);
            }

            else if (token[0].equals("Cut")){
                int index = Integer.parseInt(token[1]);
                int length = Integer.parseInt(token[2]);

                sb.append(pass);
                sb.replace(index,index+length,"");
                System.out.println(pass = sb.toString());
                sb.setLength(0);

            }

            else if (token[0].equals("Substitute")){
                String target = token[1];
                String replacement = token[2];

                if (pass.contains(target)){
                    pass=pass.replace(target,replacement);
                    System.out.println(pass);
                }else {
                    System.out.println("Nothing to replace!");
                }
            }

            input= scanner.nextLine();
        }
        System.out.println("Your password is: " + pass);

    }
}
