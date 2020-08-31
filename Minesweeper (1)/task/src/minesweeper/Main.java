package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {
    Scanner scn = new Scanner(System.in);

    public String[][] createRandomField() {
        var random = new Random();
        System.out.println("How many mines do you want on the field?");
        int numberOfMines = scn.nextInt();

        String[][] myField = new String[9][9];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                myField[i][j] = ".";
            }
        }

        while (numberOfMines > 0) {
            int i = random.nextInt(9);
            int j = random.nextInt(9);
            if (!myField[i][j].equals("X")) {
                myField[i][j] = "X";
                numberOfMines--;
            }
        }
        return myField;
    }

    public String[][] countingMinesAround(String[][] minefield) {
        int minesCount = 0;
        String [][] extendedMineField = new String[minefield.length + 2][minefield.length + 2];
        for (int i = 1; i < extendedMineField.length - 1; i++) {
            for (int j = 1; j < extendedMineField.length - 1; j++) {
                extendedMineField[i][j] = minefield[i - 1][j - 1];
            }
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
                    if (extendedMineField[i - 1][j - 1].equals("X")) {
                        minesCount++;
                    }
                    if (extendedMineField[i][j - 1].equals("X")) {
                        minesCount++;
                    }
                    if (extendedMineField[i + 1][j - 1].equals("X")) {
                        minesCount++;
                    }
                    if (extendedMineField[i - 1][j].equals("X")) {
                        minesCount++;
                    }
                    if (extendedMineField[i + 1][j].equals("X")) {
                        minesCount++;
                    }
                    if (extendedMineField[i - 1][j + 1].equals("X")) {
                        minesCount++;
                    }
                    if (extendedMineField[i][j + 1].equals("X")) {
                        minesCount++;
                    }
                    if (extendedMineField[i + 1][j + 1].equals("X")) {
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



    public static void main(String[] args) {

        Main newMain = new Main();
        String[][] myArray = newMain.createRandomField();
        String[][] extended = newMain.countingMinesAround(myArray);

        View game = new View();
        game.setGameField(extended);
        game.displayField();
    }
}
