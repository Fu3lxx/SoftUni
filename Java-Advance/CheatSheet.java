

import java.util.Scanner;
import java.util.stream.Collectors;

public class CheatSheet {
    public static void main(String[] args) {
        String a = "asdas";
        String b = "123";
        String c = "1";

        String someString = "123123";
        boolean isNumeric = a.chars().allMatch(Character::isDigit);
        System.out.println(isNumeric);

        //STACK
        // ArrayDeque<T> stack = new ArrayDeque<>();
        // Stack last added is first out
        // push - add
        //pop - remove top element
        //peek - return top element
        // size  is.Empty  cointains

        //QUEUE
        //remove the first added like queue
        //ArrayDeque<T> queue = new ArrayDeque<>();
        //offer/add() - to add element
        //.poll() - to remove element
        //.peek()

    }
    //create char matrix
    private static char[][] createMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < matrix.length; r++) {
            String[] col = scanner.nextLine().split("\\s+");
            for (int c = 0; c < col.length; c++) {
                char symbol = col[c].charAt(0);
                matrix[r][c] = symbol;
            }
        }
        return matrix;

    }
    //is matrix in bounds
    private static boolean isInBounds(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }
    /*
----------------------------------------------------------------------
     връща най тежкия елемент
    public Present heaviestPresent(){
        return this.data.stream().sorted((p1,p2)-> Double.compare(p2.getWeight(), p1.getWeight())).collect(Collectors.toList()).get(0);
    }

---------------------------------------------------------------------

    queue or stack values printed with ,

     if (bombEffectQ.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: " + bombEffectQ.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();

--------------------------------------------------------------------
то string принт
    @Override
    public String toString() {
        return "Present " + this.getName() + " (" + String.format("%.2f",this.getWeight()) + ") for a " +this.getGender().trim();
    }

--------------------------------------------------------------------
принт алл класес
    public String report() {
        StringBuilder str = new StringBuilder(String.format("%s bag contains:%n", this.getColor()));
        for (Present present : this.data) {
            str.append(present.toString()).append(System.lineSeparator());
        }
        return str.toString().trim();

----------------------------------------------------------------------------------
        remove something
          public boolean removeRabbit(String name){
        return this.data.removeIf(r-> r.getName().equals(name));
    }
----------------------------------------
get some object from data

return this.employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);

--------------------------------------------------------
 */


}
