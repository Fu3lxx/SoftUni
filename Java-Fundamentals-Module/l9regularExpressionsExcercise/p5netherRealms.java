package l9regularExpressionsExcercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p5netherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demons = Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).collect(Collectors.toList());
        Map<String,List<Double>> demonsStats = new TreeMap<>();

        for (int i = 0; i <demons.size() ; i++) {
            String currentDemon= demons.get(i).trim();

            String healthRegex = "[^0-9/\\-+*,\\.\\s*]";
            Pattern healthPattern= Pattern.compile(healthRegex);
            Matcher healthMatcher = healthPattern.matcher(currentDemon);
            double health = 0;
            while (healthMatcher.find()){
                char a = healthMatcher.group().charAt(0);
                health+= (double) a;
            }

            String damageRegex = "((?:-|\\+|)\\d+(?:\\.*?\\d+)*)";
            Pattern damagePattern= Pattern.compile(damageRegex);
            Matcher damageMatcher = damagePattern.matcher(currentDemon);

            String multiplyRegex = "[\\*\\/]";
            Pattern multiplyPattern = Pattern.compile(multiplyRegex);
            Matcher multiplyMatcher = multiplyPattern.matcher(currentDemon);
            double damage = 0;
            List<String> multiply = new ArrayList<>();
            while (damageMatcher.find()){
                damage+=Double.parseDouble(damageMatcher.group());
            }
            while (multiplyMatcher.find()){
                multiply.add(multiplyMatcher.group());
            }

            for (int j = 0; j <multiply.size() ; j++) {
                if (multiply.get(j).equals("*")){
                    damage*=2;
                }else {
                    damage=damage/2;
                }
            }
            demonsStats.put(currentDemon,new ArrayList<>());
            demonsStats.get(currentDemon).add(health);
            demonsStats.get(currentDemon).add(damage);

        }
        for (var entry:demonsStats.entrySet()){
            System.out.printf("%s - %.0f health, %.2f damage\n",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1));
        }


    }
}
