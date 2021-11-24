package l6objectAndClassesLab.p4Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List <Song> songs= new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split("_");
            Song song = new Song(input[0],input[1],input[2] );

            song.setType(input[0]);
            song.setName(input[1]);
            song.setTime(input[2]);

            songs.add(song);
        }
        String typeToPrint = scanner.nextLine();

        if (typeToPrint.equals("all")){
            for (Song music :songs){
                System.out.println(music.getName());
            }
        }else {
            for (Song music : songs){
                if (music.getType().equals(typeToPrint)){
                    System.out.println(music.getName());
                }
            }
        }

    }
}
