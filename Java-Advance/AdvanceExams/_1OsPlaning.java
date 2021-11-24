package AdvanceExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1OsPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> thread = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> task = new ArrayDeque<>(); // stack

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(task::push);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(thread::offer);

        int killerTask = Integer.parseInt(scanner.nextLine());

        while (true){
            int thr = thread.peek();
            int tsk = task.peek();
            if (tsk == killerTask){
                System.out.printf("Thread with value %d killed task %d\n",thr,tsk);
                break;
            }
            else {
                if (thr  >= tsk){
                    thread.poll();
                    task.pop();
                }
                else{
                    thread.poll();
                }
            }
        }
        thread.forEach(thr -> System.out.print(thr + " "));
    }
}
