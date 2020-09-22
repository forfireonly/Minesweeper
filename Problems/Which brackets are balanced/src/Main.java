import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Stack<String> stack = new Stack<>();
    boolean isBalanced = true;

    public boolean countBracket(String[] bracketStringArray) {
        int a = 0;
        int b = 0;
        int c = 0;
        boolean isPaired = true;
        for (String s : bracketStringArray) {
            if ("(".equals(s) || ")".equals(s)) {
                a++;
            }
            if ("[".equals(s) || "]".equals(s)) {
                b++;
            }
            if ("{".equals(s) || "}".equals(s)) {
                c++;
            }
        }
        if ((a % 2 != 0) || (b % 2 != 0) || (c % 2 != 0)) {
            isPaired = false;
        }
        return isPaired;
    }

    public void creatingStack(String s) {
        if ("(".equals(s)) {
            stack.push(")");
        }
        if ("[".equals(s)) {
            stack.push("]");
        }
        if ("{".equals(s)) {
            stack.push("}");
        }
    }

    public boolean checkBegginingOfString(String s) {
        if (("}".equals(s) || "]".equals(s)
                || ")".equals(s)) && stack.size() == 0) {
            isBalanced = false;
        }
        return isBalanced;
    }

    public boolean checkBalance(String[] bracketStringArray) {
        for (String s : bracketStringArray) {
            creatingStack(s);
            if (")".equals(s) && stack.size() != 0 && !stack.pop().equals(")")) {
                isBalanced = false;
            }
            if ("]".equals(s) && stack.size() != 0 && !stack.pop().equals("]")) {
                isBalanced = false;
            }
            if ("}".equals(s) && stack.size() != 0 && !stack.pop().equals("}")) {
                isBalanced = false;

            }
            isBalanced = checkBegginingOfString(bracketStringArray[0]);
        }
        return isBalanced;
    }


    public boolean checkBrackets() throws IOException {
        String bracketString = reader.readLine();
        String[] bracketStringArray = bracketString.split("");
        if (bracketStringArray.length % 2 != 0) {
            isBalanced = false;
        } else {
            if (countBracket(bracketStringArray)) {
                isBalanced = checkBalance(bracketStringArray);
            } else {
                isBalanced = false;
            }
        }
        return isBalanced;
    }


    public static void main(String[] args) throws IOException {
        // put your code here
        Main object = new Main();
        System.out.println(object.checkBrackets());
    }
}