import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    Deque<String> stackNeededToBeParsed = new ArrayDeque<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String stringToParse = reader.readLine();

    int lastIndexOfClosingTag = 0;
    String closingTag = "";
    int firstIndexOfClosingTag = 0;
    int firstOccuranceOfMore = 0;

    Main() throws IOException {
        /*
         *
         *
         * @author Jon Doe
         */
    }

    public void parse() {
        Deque<String> stackParsed = new ArrayDeque<>();

        firstOccuranceOfMore = stringToParse.indexOf(">");
        closingTag = "</" + stringToParse.substring(1, firstOccuranceOfMore) + ">";
        firstIndexOfClosingTag = stringToParse.indexOf(closingTag);
        lastIndexOfClosingTag = firstIndexOfClosingTag + closingTag.length();

        String parsedCurrent = stringToParse.substring(firstOccuranceOfMore + 1, firstIndexOfClosingTag);

        stackNeededToBeParsed.offerFirst(parsedCurrent);

        while (!stackNeededToBeParsed.isEmpty()) {

            String currentString = stackNeededToBeParsed.pollFirst();
            stackParsed.offerLast(currentString);

            while (currentString.contains("</")) {

                firstOccuranceOfMore = currentString.indexOf(">");
                closingTag = "</" + currentString.substring(1, firstOccuranceOfMore) + ">";
                firstIndexOfClosingTag = currentString.indexOf(closingTag);
                lastIndexOfClosingTag = firstIndexOfClosingTag + closingTag.length();

                parsedCurrent = currentString.substring(firstOccuranceOfMore + 1, firstIndexOfClosingTag);

                if (!parsedCurrent.contains("</")) {
                    stackNeededToBeParsed.offerFirst(parsedCurrent);
                    currentString = currentString.substring(lastIndexOfClosingTag);
                } else {
                    stackNeededToBeParsed.offerFirst(parsedCurrent);
                    currentString = currentString.substring(lastIndexOfClosingTag);
                }
            }
        }

        Iterator<String> it = stackParsed.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) throws IOException {
        // put your code here
        Main parser = new Main();
        parser.parse();
    }
}