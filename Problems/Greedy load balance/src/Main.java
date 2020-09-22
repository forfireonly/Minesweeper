import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> firstQue = new ArrayDeque<>();
    Queue<Integer> secondQue = new ArrayDeque<>();

    public void distributeTasks() throws IOException {

        int numberOfTasks = Integer.parseInt(reader.readLine());
        int loadSum1 = Integer.parseInt(reader.readLine().split(" ")[1]);
        int loadSum2 = 0;
        firstQue.offer(1);
        for (int i = 2; i <= numberOfTasks; i++) {
            int load = Integer.parseInt(reader.readLine().split(" ")[1]);
            if (loadSum1 > loadSum2) {
                secondQue.offer(i);
                loadSum2 = loadSum2 + load;
            } else {
                firstQue.offer(i);
                loadSum1 = loadSum1 + load;
            }
        }
        while (!firstQue.isEmpty()) {
            System.out.print(firstQue.remove() + " ");
        }
        System.out.println();
        while (!secondQue.isEmpty()) {
            System.out.print(secondQue.remove() + " ");
        }

    }
    public static void main(String[] args) throws IOException {
        // put your code here
        Main distibutor = new Main();
        distibutor.distributeTasks();
    }
}