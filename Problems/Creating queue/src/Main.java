import java.util.*;

public class Main {

    public static void main(String[] args) {  
        // write your code here
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerFirst(7);
        queue.offerFirst(1);
        queue.offerFirst(0);
        queue.offerFirst(2);
        System.out.println(queue);
    }
}