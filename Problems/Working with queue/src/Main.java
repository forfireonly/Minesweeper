import java.util.*;

public class Main {

    public static void main(String[] args) {        
        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4));

        // write your code here

        queue.poll();
        queue.poll();
        queue.offer(5);
        System.out.println(queue);
    }
}