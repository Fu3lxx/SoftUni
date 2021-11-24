package finalExamFund;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Integer> userLikesC = new TreeMap<>();
        //Map<String , Integer> userComments = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Log out")){
            String [] token = input.split(": ");
            String command = token[0];
            String user = token[1];



            switch (command){
                case "New follower":
                    if (!userLikesC.containsKey(user)){
                        userLikesC.put(user,0);

                    }
                    break;

                case "Like":
                    int count = Integer.parseInt(token[2]);

                    if (!userLikesC.containsKey(user)){
                        userLikesC.put(user,count);

                    }
                    else {
                        int currentLikes =userLikesC.get(user);
                        userLikesC.put(user,currentLikes+count);
                    }
                    break;

                case "Comment":
                    if (!userLikesC.containsKey(user)){
                        userLikesC.put(user,1);
                    }
                    else {
                        int currentComments = userLikesC.get(user);
                        userLikesC.put(user,currentComments+1);
                    }
                    break;

                case "Blocked":
                    if (userLikesC.containsKey(user)){
                        userLikesC.remove(user);
                    }
                    else {
                        System.out.printf("%s doesn't exist.\n",user);
                    }
                    break;
            }



            input= scanner.nextLine();
        }
        System.out.printf("%d followers\n",userLikesC.size());

        userLikesC.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x-> System.out.printf("%s: %d\n",x.getKey(),x.getValue()));

    }
}
