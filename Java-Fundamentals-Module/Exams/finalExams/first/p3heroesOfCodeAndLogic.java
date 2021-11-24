package finalExams.first;

import java.util.*;

public class p3heroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < times; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            map.put(input[0], new ArrayList<>());
            map.get(input[0]).add(Integer.parseInt(input[1]));
            map.get(input[0]).add(Integer.parseInt(input[2]));

        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split(" - ");
            String command = token[0];
            String name = token[1];

            if (command.equals("Heal")) {
                int heal = Integer.parseInt(token[2]);
                int current = map.get(name).get(0);
                if (current + heal <= 100) {
                    map.get(name).set(0, current + heal);
                    System.out.println(name + " healed for " + heal + " HP!");
                } else {
                    int healed = Math.abs(heal + current - 100 - heal);
                    map.get(name).set(0,100);
                    System.out.println(name + " healed for " + healed + " HP!");
                }
            } else if (command.equals("Recharge")) {
                int mana = Integer.parseInt(token[2]);
                int current = map.get(name).get(1);
                if (current + mana <= 200) {
                    System.out.println(name + " recharged for " + mana + " MP!");
                    map.get(name).set(1, current + mana);
                } else {
                    int healed = Math.abs(mana + current - 200 - mana);
                    map.get(name).set(1,200);
                    System.out.println(name + " recharged for " + healed + " MP!");
                }
            } else if (command.equals("TakeDamage")) {
                int damage = Integer.parseInt(token[2]);
                String attacker = token[3];
                int current = map.get(name).get(0);
                if (current - damage > 0) {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", name, damage, attacker, current - damage);
                    map.get(name).set(0, current - damage);
                } else {
                    System.out.printf("%s has been killed by %s!\n", name, attacker);
                    map.remove(name);
                }
            } else if (command.equals("CastSpell")) {
                int mana = Integer.parseInt(token[2]);
                int current = map.get(name).get(1);
                String magic = token[3];
                if (current - mana >= 0) {
                    System.out.printf("%s has successfully cast %s and now has %d MP!\n", name, magic, current - mana);
                    map.get(name).set(1, current - mana);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!\n", name, magic);
                }
            }
            input = scanner.nextLine();
        }

        map.entrySet()
                .stream()
                .sorted((a,b) -> b.getValue().get(0).compareTo(a.getValue().get(0)))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    System.out.println(" HP: " + entry.getValue().get(0));
                    System.out.println(" MP: " + entry.getValue().get(1));
                });




    }


}