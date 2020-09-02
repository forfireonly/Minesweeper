import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {

    Scanner scn = new Scanner(System.in);
    Deque<Integer> stack = new ArrayDeque<>();

    public void readSort() {
        int sizeOfDeque = scn.nextInt();
        while (scn.hasNext()) {
            int number = scn.nextInt();

            if (number % 2 == 0) {
                stack.offerFirst(number);
            } else {
                stack.offerLast(number);
            }
        }
        for (int i = 0; i < sizeOfDeque; i++) {
            System.out.println(stack.peekFirst());
            stack.pollFirst();
        }

    }

    public static void main(String[] args) {
        // put your code here

        Main runDeque = new Main();
        runDeque.readSort();
    }
}