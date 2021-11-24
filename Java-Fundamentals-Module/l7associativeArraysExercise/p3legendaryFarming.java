package l7associativeArraysExercise;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3legendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String , Integer> keyMaterials = new TreeMap<>();
        Map <String , Integer> trashMaterials = new TreeMap<>();

        keyMaterials.put("shards" , 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean crafted=false;

        while (!crafted) {
            String[] data = scanner.nextLine().toLowerCase(Locale.ROOT).split("\\s+");

            for (int i = 0; i < data.length; i++) {
                if (crafted){
                    break;
                }

                if (i % 2 !=0){

                    if (data[i].equals("shards") || data[i].equals("fragments") || data[i].equals("motes")){
                        int current = keyMaterials.get(data[i]);
                        keyMaterials.put(data[i],current+ Integer.parseInt(data[i-1]) );

                        if (keyMaterials.get(data[i]) >= 250 ){
                            String material = data[i];
                            int currentt = keyMaterials.get(material);
                            if (material.equals("shards")){
                                System.out.println("Shadowmourne obtained!");
                                keyMaterials.put(material, currentt-250);
                                crafted=true;
                            }
                            else if (material.equals("fragments")){
                                System.out.println("Valanyr obtained!");
                                keyMaterials.put(material, currentt-250);
                                crafted=true;
                            }
                            else if (material.equals("motes")){
                                System.out.println("Dragonwrath obtained!");
                                keyMaterials.put(material, currentt-250);
                                crafted=true;
                            }
                        }

                    }else {
                        trashMaterials.putIfAbsent(data[i],0 );
                        int current =trashMaterials.get(data[i]);
                        trashMaterials.put(data[i],current + Integer.parseInt(data[i-1]) );
                    }
                }
            }

        }
        keyMaterials.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry ->System.out.println(entry.getKey() +": " + entry.getValue()));
        //trashMaterials.entrySet().stream().forEach(entry ->System.out.println(entry.getKey() +": " + entry.getValue())));
        for (var entry : trashMaterials.entrySet()){
            System.out.println(entry.getKey() +": " + entry.getValue());
        }
    }
}
