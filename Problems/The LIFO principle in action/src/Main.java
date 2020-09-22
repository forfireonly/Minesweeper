import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main {
    static class  ReverseElements {
        static Scanner scn = new Scanner(System.in);

        static Stack<Integer> stack = new Stack<>();
        static List<Integer> list = new ArrayList<>();

        static void readArrayList(){
            int size = scn.nextInt();
            for (int i = 0; i < size; i++) {
                list.add(scn.nextInt());
            }
        }

        static void reverseList() {
            while(list.size() > 0) {
                stack.push(list.remove(0));
            }

            while (stack.size() > 0) {
                list.add(stack.pop());
            }

            for (int item : list) {
                System.out.println(item);
            }
        }



    }
    public static void main(String[] args) {
        // put your code here
        ReverseElements.readArrayList();
        ReverseElements.reverseList();
    }
}