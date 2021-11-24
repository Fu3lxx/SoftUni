package finalExamPartTwo;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3heroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String,Integer> nameIhp = new TreeMap<>();
        Map <String,Integer> nameImp = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(" ");
            String name = data[0];
            int hp = Integer.parseInt(data[1]);
            int mp = Integer.parseInt(data[2]);

            nameIhp.put(name,hp);
            nameImp.put(name,mp);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String [] data = input.split(" - ");
            String command = data[0];
            String name = data[1];

            int currentHP = nameIhp.get(name);
            int currentMP = nameImp.get(name);

            switch (command){
                case "Heal":
                    int heal = Integer.parseInt(data[2]);
                    if (currentHP+heal<=100){
                        System.out.printf("%s healed for %d HP!\n",name,heal);
                        nameIhp.put(name,currentHP+heal);
                    }else {
                        System.out.printf("%s healed for %d HP!\n",name,100-currentHP);
                        nameIhp.put(name,100);
                    }

                    break;
                case "CastSpell":

                    int mpNeed = Integer.parseInt(data[2]);
                    String spellName = data[3];
                    if (currentMP>=mpNeed){
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",name,spellName,currentMP-mpNeed);
                        nameImp.put(name,currentMP-mpNeed);
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!\n",name,spellName);
                    }
                    break;
                case "TakeDamage":

                    int damage = Integer.parseInt(data[2]);
                    String attacker = data[3];
                    if (currentHP-damage>0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",name,damage,attacker,currentHP-damage);
                        nameIhp.put(name,currentHP-damage);
                    }else {
                        System.out.printf("%s has been killed by %s!\n",name,attacker);
                        nameIhp.remove(name);
                        nameImp.remove(name);
                    }
                    break;
                case "Recharge":

                    int amount = Integer.parseInt(data[2]);
                    if (currentMP + amount <=200){
                        System.out.printf("%s recharged for %d MP!\n",name,amount);
                        nameImp.put(name,currentMP+amount);
                    }else {
                        System.out.printf("%s recharged for %d MP!\n",name,200-currentMP);
                        nameImp.put(name,200);
                    }
                    break;
            }

            input= scanner.nextLine();
        }



        nameIhp.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(x -> System.out.printf("%s\n HP: %d\n MP: %d\n",x.getKey(),x.getValue(),nameImp.get(x.getKey())));
    }
}
