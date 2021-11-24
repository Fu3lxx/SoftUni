package l9regularExpressionsExcercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p4starEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int codes = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < codes; i++) {
            String code = scanner.nextLine();
            String codeRegex = "[sStTaArR]";
            Pattern patternName = Pattern.compile(codeRegex);
            Matcher matcherName = patternName.matcher(code);

            int counter =0;
            while(matcherName.find()){
                counter++;
            }

            StringBuilder encryptedCode = new StringBuilder();
            for (int j = 0; j < code.length(); j++) {
                char currentSymbol = code.charAt(j);
                encryptedCode.append((char) (currentSymbol - counter));
            }

            String finalCode = encryptedCode.toString();
            String regex = "@(?<planet>[A-Z][a-z]+)[^@\\-!:>]*:(\\d+)[^@\\-!:>]*!(?<position>[AD])![^@\\-!:>]*->(\\d+)";
            Pattern codePattern = Pattern.compile(regex);
            Matcher codeMatcher = codePattern.matcher(finalCode);

            if (codeMatcher.find()){
                String position = codeMatcher.group("position").toUpperCase(Locale.ROOT);
                String planet = codeMatcher.group("planet");

                if (position.equals("A")){
                    attacked.add(planet);
                }else {
                    destroyed.add(planet);
                }

            }






        }
        Collections.sort(destroyed);
        Collections.sort(attacked);
        System.out.println("Attacked planets: " + attacked.size());
        if (!attacked.isEmpty()){
            attacked.forEach(p -> System.out.println("-> " + p));
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        if (!destroyed.isEmpty()){
            destroyed.forEach(p -> System.out.println("-> " + p));
        }
    }
}
