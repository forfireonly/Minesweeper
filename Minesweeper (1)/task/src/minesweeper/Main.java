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
                /*if (random.nextBoolean()) {
                    myField[i][j] = ".";
                } else {
                    myField[i][j] = "X";
                }*/
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



    public static void main(String[] args) {
        // write your code here
        /*String[][] myArray = {
                {".", "X", ".",".",".",".",".",".","."},
                {".", ".", ".",".",".","X",".",".","X"},
                {".", ".", ".",".","X",".",".",".","."},
                {".", ".", "X",".",".",".",".",".","."},
                {".", ".", ".","X",".",".",".",".","."},
                {".", "X", ".",".",".",".",".",".","."},
                {".", "X", ".",".",".",".",".",".","."},
                {".", ".", ".",".",".",".","X",".","."},
                {".", ".", ".",".",".","X",".",".","."},

        };*/
        Main newMain = new Main();
        String[][] myArray = newMain.createRandomField();

        View game = new View();
        game.setGameField(myArray);
        game.displayField();
    }
}
