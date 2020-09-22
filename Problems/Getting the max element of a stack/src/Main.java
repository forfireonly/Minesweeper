import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Deque<Integer> myStack = new ArrayDeque<>();
    Deque<Integer> maxStack = new ArrayDeque<>();

    public void calcMax() throws IOException {
        int numberOfCommands = Integer.parseInt(reader.readLine());
        int max = 0;
        Integer element = 0;

        for (int i = 0; i < numberOfCommands; i++) {
            String command = reader.readLine();
            String[] commandArray = command.split(" ");
            if (commandArray.length == 1) {
                if ("pop".equals(command)) {
                    element = myStack.pollFirst();
                    //System.out.println(element);
                    if (element != null && maxStack.peekFirst() != null && element.equals(maxStack.peekFirst())) {
                        maxStack.pollFirst();
                        max = maxStack.peekFirst(); 
                    }
                }
                if ("max".equals(command)) {
                    System.out.println(maxStack.peekFirst());

                }
            } else {
                int number = Integer.parseInt(commandArray[1]);
                myStack.offerFirst(number);
                if (number >= max) {
                    maxStack.offerFirst(number);
                    max = number;
                } else {
                    maxStack.offerLast(number);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // put your code here
        Main myStack = new Main();
        myStack.calcMax();
    }
}
