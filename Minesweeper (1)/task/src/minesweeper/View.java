package minesweeper;

import java.lang.reflect.Array;

public class View {

    private String[][] gameField;

    public void setGameField(String[][] gameField) {
        this.gameField = gameField;
    }

    public String[][] getGameField() {
        return gameField;
    }

    public void displayField() {
        System.out.println(toString());

    }

    @Override
    public String toString() {
        StringBuilder gameFieldString = new StringBuilder();
        for (String[] strings : gameField) {
            for (String string : strings) {
                gameFieldString.append(string);
            }
            gameFieldString.append("\r\n");
        }
        return String.valueOf(gameFieldString);
    }
}
