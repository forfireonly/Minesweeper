package minesweeper;

import java.util.Random;

public class Main {

    public String[][] createRandomField() {
        var random = new Random();
        String[][] myField = new String[9][9];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                if (random.nextBoolean()) {
                    myField[i][j] = ".";
                } else {
                    myField[i][j] = "X";
                }
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
