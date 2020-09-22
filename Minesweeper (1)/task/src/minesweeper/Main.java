package minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;


public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<Integer, Integer> mines = new HashMap<>();

    int row;
    int column;
    String freeOrMine;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getFreeOrMine() {
        return freeOrMine;
    }

    public String[][] createRandomField() throws IOException {
        String coordinatesString;
        String[] coordinatesArray;

        var random = new Random();
        System.out.println("How many mines do you want on the field?");
        int numberOfMines = Integer.parseInt(reader.readLine());

        View startingField = new View();
        String[][] startFiledLook = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                startFiledLook[i][j] = ".";
            }
        }

        startingField.setGameField(startFiledLook);
        startingField.displayField();

        System.out.println("Set/unset mines marks or claim a cell as free: ");

        coordinatesString = Main.reader.readLine();
        coordinatesArray = coordinatesString.split(" ");
        column = Integer.parseInt(coordinatesArray[0]) - 1;
        row = Integer.parseInt(coordinatesArray[1]) - 1;
        freeOrMine = coordinatesArray[2];

        System.out.println();

        String[][] myField = new String[9][9];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                myField[i][j] = ".";
            }
        }

        if (freeOrMine.equals("free")) {
            myField[row][column] = "/";
        } else if (freeOrMine.equals("mine")) {
            myField[row][column] = "*";
        }

       // while (numberOfMines > 0) {
        for (int i = 0; i < myField.length; i++) {
            for (int j = 0; j < myField.length; j++) {

            //int i = random.nextInt(9);
            //int j = random.nextInt(9);
            if (!myField[i][j].equals("*") && j != column && i != row && j != column - 1
                    && i != row - 1 && j != column + 1 && i != row + 1) {
                myField[i][j] = "*";
                mines.put(i, j);

                numberOfMines--;
            }
            }
        }
        //}

        return countingMinesAround(myField);
    }

    public String[][] countingMinesAround(String[][] minefield) {
        int minesCount = 0;
        String [][] extendedMineField = new String[minefield.length + 2][minefield.length + 2];
        for (int i = 1; i < extendedMineField.length - 1; i++) {
            System.arraycopy(minefield[i - 1], 0, extendedMineField[i], 1, extendedMineField.length - 1 - 1);
        }
        for (int i = 0; i < extendedMineField.length; i++) {
            extendedMineField[0][i] = ".";
        }
        for (int i = 0; i < extendedMineField.length; i++) {
            extendedMineField[extendedMineField.length - 1][i] = ".";
        }
        for (int i = 0; i < extendedMineField.length; i++) {
            extendedMineField[i][0] = ".";
        }
        for (int i = 0; i < extendedMineField.length; i++) {
            extendedMineField[i][extendedMineField.length - 1] = ".";
        }

        for (int i = 1; i < extendedMineField.length - 1; i++) {
            for (int j = 1; j < extendedMineField.length - 1; j++) {
                if (minefield[i - 1][j - 1].equals(".")) {
                    minesCount = 0;
                    if (extendedMineField[i - 1][j - 1].equals("*")) {
                        minesCount++;
                    }
                    if (extendedMineField[i][j - 1].equals("*")) {
                        minesCount++;
                    }
                    if (extendedMineField[i + 1][j - 1].equals("*")) {
                        minesCount++;
                    }
                    if (extendedMineField[i - 1][j].equals("*")) {
                        minesCount++;
                    }
                    if (extendedMineField[i + 1][j].equals("*")) {
                        minesCount++;
                    }
                    if (extendedMineField[i - 1][j + 1].equals("*")) {
                        minesCount++;
                    }
                    if (extendedMineField[i][j + 1].equals("*")) {
                        minesCount++;
                    }
                    if (extendedMineField[i + 1][j + 1].equals("*")) {
                        minesCount++;
                    }
                    if (minesCount > 0) {
                        minefield[i - 1][j - 1] = String.valueOf(minesCount);

                    }
                }

            }
        }

        return minefield;
    }

    public static void main(String[] args) throws IOException {

        Game newGame = new Game();
        newGame.runGame();
    }
}
