package minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String[][] createRandomField() throws IOException {
        var random = new Random();
        System.out.println("How many mines do you want on the field?");
        int numberOfMines = Integer.parseInt(reader.readLine());

        String[][] myField = new String[9][9];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                myField[i][j] = ".";
            }
        }

        while (numberOfMines > 0) {

            int i = random.nextInt(9);
            int j = random.nextInt(9);
            if (!myField[i][j].equals("*")) {
            myField[i][j] = "*";

                numberOfMines--;
            }
        }
        return myField;
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
