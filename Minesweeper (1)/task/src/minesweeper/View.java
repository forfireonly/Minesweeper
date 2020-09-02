package minesweeper;

public class View {

    private String[][] gameField;

    public void setGameField(String[][] gameField) {
        this.gameField = gameField;
    }

    public String[][] getGameField() {
        return gameField;
    }

    public void displayField() {
        System.out.println(" │123456789│");
        System.out.println("—│—————————│");
        System.out.print(toString());
        System.out.println("—│—————————│");

    }

    @Override
    public String toString() {
        StringBuilder gameFieldString = new StringBuilder();
        int i = 1;
        for (String[] strings : gameField) {
            gameFieldString.append(i).append("|");
            for (String string : strings) {
                gameFieldString.append(string);
            }
            gameFieldString.append("|\r\n");
            i = i + 1;
        }
        return String.valueOf(gameFieldString);
    }
}
