package WorkingWithAbstractionExercise.jediGalaxy;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        Scanner scanner = new Scanner(System.in);


        int[] dimensions = InputParser.parseIntegerArray(reader.readLine());

        Field field = new Field(dimensions[0],dimensions[1] );
        field.fillField();
        Player player = new Player(field);
        Enemy enemy = new Enemy(field);

        String startPoint = reader.readLine();
        while (!startPoint.equals("Let the Force be with you")){

            int [] playerStart = InputParser.parseIntegerArray(startPoint);
            int [] enemyStart = InputParser.parseIntegerArray(reader.readLine());

            player.setNewStart(playerStart[0],playerStart[1] );
            enemy.setNewStart(enemyStart[0],enemyStart[1] );

            enemy.destroyStars();
            player.collectStars();

            startPoint = reader.readLine();
        }
        System.out.println(player.getStars());



    }
}
