package minesweeper;

import java.io.IOException;
import java.util.Arrays;

public class Game {

    Main newMain = new Main();
    View gameView = new View();

    public void runGame() throws IOException {


        String[][] myArray = newMain.createRandomField();
        String[][] extended = newMain.countingMinesAround(myArray);
        String[][] filedShowingMines = new String[9][9];

        for (int i = 0; i < 9; i++) {
            System.arraycopy(extended[i], 0, filedShowingMines[i], 0, 9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (extended[i][j].equals("*")) {
                    extended[i][j] = ".";
                }
            }
        }

            gameView.setGameField(extended);
            gameView.displayField();

            String coordinatesString;
            String[] coordinatesArray;

            int row;
            int column;

            boolean isSolved = false;
            while (!isSolved) {
                System.out.println("Set/delete mines marks (x and y coordinates):");
                coordinatesString = Main.reader.readLine();
                coordinatesArray = coordinatesString.split(" ");
                column = Integer.parseInt(coordinatesArray[0]) - 1;
                row = Integer.parseInt(coordinatesArray[1]) - 1;
                if (extended[row][column].equals(".")) {
                    extended[row][column] = "*";
                    gameView.displayField();
                    isSolved = Arrays.deepEquals(extended, filedShowingMines);

                } else if (extended[row][column].equals("*")) {
                    extended[row][column] = ".";
                    gameView.displayField();
                    isSolved = Arrays.deepEquals(extended, filedShowingMines);

                } else {
                    System.out.println("There is a number here!");
                }
            }

            System.out.println("Congratulations! You found all mines!");
        }

    }





