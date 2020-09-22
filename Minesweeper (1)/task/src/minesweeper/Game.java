package minesweeper;

import java.io.IOException;
import java.util.*;

import static minesweeper.Main.mines;

public class Game {

    HashMap<Integer, Integer> guessedMines = new HashMap<>();

    Main newMain = new Main();
    View gameView = new View();

    String[][] myArray; //= newMain.createRandomField();
    String[][] extended;// = newMain.countingMinesAround(myArray);
    String[][] filedShowingMines;// = new String[9][9];

    String digitRegex = "\\d";

    Deque<Integer> rows = new ArrayDeque<>();
    Deque<Integer> columns = new ArrayDeque<>();
    public Game() throws IOException {
    }

    public void exploreCells(String[][] filedShowingMines) {
        int row = 0;
        int column = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (filedShowingMines[i][j].equals("/")) {
                    row = i;
                    column = j;
                }
            }
        }
        exploreSingleCell(row, column);

    }

    public void clearFreeMines() {

        int currentRow = 0;
        int currentColumn = 0;

        while (!rows.isEmpty()){
                currentRow = rows.pop();
                currentColumn = columns.pop();

            exploreSingleCell(currentRow, currentColumn);
        };
    }

    public void exploreSingleCell(int row, int column) {
        //four coners
        if (row == 0 && column == 0) {
            if (filedShowingMines[row][column + 1].matches(digitRegex)) {
                extended[row][column + 1] = filedShowingMines[row][column + 1];
            } else if (filedShowingMines[row][column + 1].equals(".") && !extended[row][column + 1].equals("/")){
                    extended[row][column + 1] = "/";
                    rows.offerLast(row);
                    columns.offerLast(column + 1);
            }
            if (filedShowingMines[row + 1][column + 1].matches(digitRegex)) {
                extended[row + 1][column + 1] = filedShowingMines[row + 1][column + 1];
            } else if (filedShowingMines[row + 1][column + 1].equals(".") && !extended[row + 1][column + 1].equals("/")){
                extended[row + 1][column + 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column + 1);
            }
            if (filedShowingMines[row + 1][column].matches(digitRegex)) {
                extended[row + 1][column] = filedShowingMines[row + 1][column];
            } else if (filedShowingMines[row + 1][column].equals(".") && !extended[row + 1][column].equals("/")){
                extended[row + 1][column] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column);
            }

        } else if (column == 8 && row == 0) {
            if (filedShowingMines[row][column - 1].matches(digitRegex)) {
                extended[row][column - 1] = filedShowingMines[row][column - 1];
            } else if (filedShowingMines[row][column - 1].equals(".") && !extended[row][column - 1].equals("/")){
                extended[row][column - 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row + 1][column - 1].matches(digitRegex)) {
                extended[row + 1][column - 1] = filedShowingMines[row + 1][column - 1];
            } else if (filedShowingMines[row + 1][column - 1].equals(".") && !extended[row + 1][column - 1].equals("/")) {
                extended[row + 1][column - 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row + 1][column ].matches(digitRegex)) {
                extended[row + 1][column] = filedShowingMines[row + 1][column];
            } else if (filedShowingMines[row + 1][column ].equals(".") && !extended[row + 1][column].equals("/")) {
                extended[row + 1][column] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column);
            }


        } else if (column == 0 && row == 8) {
            if (filedShowingMines[row - 1 ][column].matches(digitRegex)) {
                extended[row - 1 ][column] = filedShowingMines[row - 1][column];
            } else if (filedShowingMines[row - 1 ][column].equals(".") && !extended[row - 1 ][column].equals("/")){
                extended[row - 1 ][column] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row - 1][column + 1].matches(digitRegex)) {
                extended[row - 1][column + 1] = filedShowingMines[row - 1][column + 1];
            } else if (filedShowingMines[row - 1][column + 1].equals(".") && !extended[row - 1][column + 1].equals("/")){
                extended[row - 1][column + 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column + 1);
            }
            if (filedShowingMines[row][column + 1].matches(digitRegex)) {
                extended[row][column + 1] = filedShowingMines[row][column + 1];
            } else if (filedShowingMines[row][column + 1].equals(".") && !extended[row][column + 1].equals("/")){
                extended[row][column + 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column + 1);
            }

        } else if (row == 8 && column == 8) {
            if (filedShowingMines[row - 1][column].matches(digitRegex)) {
                extended[row - 1][column] = filedShowingMines[row - 1][column];
            } else if (filedShowingMines[row - 1][column].equals(".") && !extended[row - 1][column].equals("/")){
                extended[row - 1][column] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row - 1][column - 1].matches(digitRegex)) {
                extended[row - 1][column - 1] = filedShowingMines[row - 1][column - 1];
            } else if (filedShowingMines[row - 1][column - 1].equals(".") && !extended[row - 1][column - 1].equals("/")){
                extended[row - 1][column - 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row][column - 1].matches(digitRegex)) {
                extended[row][column - 1] = filedShowingMines[row][column - 1];
            } else if (filedShowingMines[row][column - 1].equals(".") && !extended[row][column - 1].equals("/")){
                extended[row][column - 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column - 1);
            }

            //four sides
        } else if (row == 0) {
            if (filedShowingMines[row][column - 1].matches(digitRegex)) {
                extended[row][column - 1] = filedShowingMines[row][column - 1];
            } else if (filedShowingMines[row][column - 1].equals(".") && !extended[row][column - 1].equals("/")){
                extended[row][column - 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row][column + 1].matches(digitRegex)) {
                extended[row][column + 1] = filedShowingMines[row][column + 1];
            } else if (filedShowingMines[row][column + 1].equals(".") && !extended[row][column + 1].equals("/")){
                extended[row][column + 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column + 1);
            }
            if (filedShowingMines[row + 1][column - 1].matches(digitRegex)) {
                extended[row + 1][column - 1] = filedShowingMines[row + 1][column - 1];
            } else if (filedShowingMines[row + 1][column - 1].equals(".") && !extended[row + 1][column - 1].equals("/")){
                extended[row + 1][column - 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row + 1][column].matches(digitRegex)) {
                extended[row + 1][column] = filedShowingMines[row + 1][column];
            } else if (filedShowingMines[row + 1][column].equals(".") && !extended[row + 1][column].equals("/")){
                extended[row + 1][column] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row + 1][column + 1].matches(digitRegex)) {
                extended[row + 1][column + 1] = filedShowingMines[row + 1][column + 1];
            } else if (filedShowingMines[row + 1][column + 1].equals(".") && !extended[row + 1][column + 1].equals("/")){
                extended[row + 1][column + 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column + 1);
            }
        } else if (row == 8) {
            if (filedShowingMines[row][column - 1].matches(digitRegex)) {
                extended[row][column - 1] = filedShowingMines[row][column - 1];
            } else if (filedShowingMines[row][column - 1].equals(".") && !extended[row][column - 1].equals("/")){
                extended[row][column - 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row][column + 1].matches(digitRegex)) {
                extended[row][column + 1] = filedShowingMines[row][column + 1];
            } else if (filedShowingMines[row][column + 1].equals(".") && !extended[row][column + 1].equals("/")){
                extended[row][column + 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column + 1);
            }
            if (filedShowingMines[row - 1][column - 1].matches(digitRegex)) {
                extended[row - 1][column - 1] = filedShowingMines[row - 1][column - 1];
            } else if (filedShowingMines[row - 1][column - 1].equals(".") && !extended[row - 1][column - 1].equals("/")){
                extended[row - 1][column - 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row - 1][column].matches(digitRegex)) {
                extended[row - 1][column] = filedShowingMines[row - 1][column];
            } else if (filedShowingMines[row - 1][column].equals(".") && !extended[row - 1][column].equals("/")) {
                extended[row - 1][column] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row - 1][column + 1].matches(digitRegex)) {
                extended[row - 1][column + 1] = filedShowingMines[row - 1][column + 1];
            } else if (filedShowingMines[row - 1][column + 1].equals(".") && !extended[row - 1][column + 1].equals("/")){
                extended[row - 1][column + 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column + 1);
            }
        } else if (column == 0) {
            if (filedShowingMines[row - 1][column].matches(digitRegex)) {
                extended[row - 1][column] = filedShowingMines[row - 1][column];
            } else if (filedShowingMines[row - 1][column].equals(".") && !extended[row - 1][column].equals("/")){
                extended[row - 1][column] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row - 1][column + 1].matches(digitRegex)) {
                extended[row - 1][column + 1] = filedShowingMines[row - 1][column + 1];
            } else if (filedShowingMines[row - 1][column + 1].equals(".") && !extended[row - 1][column + 1].equals("/")){
                extended[row - 1][column + 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column + 1);
            }
            if (filedShowingMines[row][column + 1].matches(digitRegex)) {
                extended[row][column + 1] = filedShowingMines[row][column + 1];
            } else if (filedShowingMines[row][column + 1].equals(".") && !extended[row][column + 1].equals("/")) {
                extended[row][column + 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column + 1);
            }
            if (filedShowingMines[row + 1][column].matches(digitRegex)) {
                extended[row + 1][column] = filedShowingMines[row + 1][column];
            } else if (filedShowingMines[row + 1][column].equals(".") && !extended[row + 1][column].equals("/")) {
                extended[row + 1][column] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row + 1][column + 1].matches(digitRegex)) {
                extended[row + 1][column + 1] = filedShowingMines[row + 1][column + 1];
            } else if (filedShowingMines[row + 1][column + 1].equals(".") && !extended[row + 1][column + 1].equals("/")) {
                extended[row + 1][column + 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column + 1);
            }
        } else if (column == 8) {
            if (filedShowingMines[row - 1][column - 1].matches(digitRegex)) {
                extended[row - 1][column - 1] = filedShowingMines[row - 1][column - 1];
            } else if (filedShowingMines[row - 1][column - 1].equals(".") && !extended[row - 1][column - 1].equals("/")) {
                extended[row - 1][column - 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row - 1][column].matches(digitRegex)) {
                extended[row - 1][column] = filedShowingMines[row - 1][column];
            } else if (filedShowingMines[row - 1][column].equals(".") && !extended[row - 1][column].equals("/")) {
                extended[row - 1][column] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row][column - 1].matches(digitRegex)) {
                extended[row][column - 1] = filedShowingMines[row][column - 1];
            } else if (filedShowingMines[row][column - 1].equals(".") && !extended[row][column - 1].equals("/")) {
                extended[row][column - 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row + 1][column - 1].matches(digitRegex)) {
                extended[row + 1][column - 1] = filedShowingMines[row + 1][column - 1];
            } else if (filedShowingMines[row + 1][column - 1].equals(".") && !extended[row + 1][column - 1].equals("/")) {
                extended[row + 1][column - 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row + 1][column].matches(digitRegex)) {
                extended[row + 1][column] = filedShowingMines[row + 1][column];
            } else if (filedShowingMines[row + 1][column].equals(".") && !extended[row + 1][column].equals("/")){
                extended[row + 1][column] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column);
            }
        } else {
            if (filedShowingMines[row - 1][column - 1].matches(digitRegex)) {
                extended[row - 1][column - 1] = filedShowingMines[row - 1][column - 1];
            } else if (filedShowingMines[row - 1][column - 1].equals(".") && !extended[row - 1][column - 1].equals("/")) {
                extended[row - 1][column - 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row - 1][column].matches(digitRegex)) {
                extended[row - 1][column] = filedShowingMines[row - 1][column];
            } else if (filedShowingMines[row - 1][column].equals(".") && !extended[row - 1][column].equals("/")) {
                extended[row - 1][column] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row - 1 ][column + 1].matches(digitRegex)) {
                extended[row - 1][column + 1] = filedShowingMines[row - 1][column + 1];
            } else if (filedShowingMines[row -1 ][column + 1].equals(".") && !extended[row -1 ][column + 1].equals("/")) {
                extended[row - 1][column + 1] = "/";
                rows.offerLast(row - 1);
                columns.offerLast(column + 1);;
            }
            if (filedShowingMines[row][column - 1].matches(digitRegex)) {
                extended[row][column - 1] = filedShowingMines[row][column - 1];
            } else if (filedShowingMines[row][column - 1].equals(".") && !extended[row][column - 1].equals("/")) {
                extended[row][column - 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row][column + 1].matches(digitRegex)) {
                extended[row][column + 1] = filedShowingMines[row][column + 1];
            } else if (filedShowingMines[row][column + 1].equals(".") && !extended[row][column + 1].equals("/")) {
                extended[row][column + 1] = "/";
                rows.offerLast(row);
                columns.offerLast(column + 1);
            }
            if (filedShowingMines[row + 1][column - 1].matches(digitRegex)) {
                extended[row + 1][column - 1] = filedShowingMines[row + 1][column - 1];
            } else if (filedShowingMines[row + 1][column - 1].equals(".") && !extended[row + 1][column - 1].equals("/")){
                extended[row + 1][column - 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column - 1);
            }
            if (filedShowingMines[row + 1][column].matches(digitRegex)) {
                extended[row + 1][column] = filedShowingMines[row + 1][column];
            } else if (filedShowingMines[row + 1][column].equals(".") && !extended[row + 1][column].equals("/")) {
                extended[row + 1][column] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column);
            }
            if (filedShowingMines[row + 1][column + 1].matches(digitRegex)) {
                extended[row + 1][column + 1] = filedShowingMines[row + 1][column + 1];
            } else if (filedShowingMines[row + 1][column + 1].equals(".") && !extended[row + 1][column + 1].equals("/")){
                extended[row + 1][column + 1] = "/";
                rows.offerLast(row + 1);
                columns.offerLast(column + 1);
            }
        }
    }

    public void runGame() throws IOException {

        int row = 0;
        int column = 0;
        String freeOrMine = "";


        extended = newMain.createRandomField();

        filedShowingMines = new String[9][9];

        for (int i = 0; i < 9; i++) {
            System.arraycopy(extended[i], 0, filedShowingMines[i], 0, 9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (extended[i][j].equals("*")) {
                    extended[i][j] = ".";
                }
                if (extended[i][j].matches(digitRegex))  {
                    extended[i][j] = ".";
                }
            }
        }

        row = newMain.getRow();
        column = newMain.getColumn();
        freeOrMine = newMain.getFreeOrMine();

        if (freeOrMine.equals("mine")) {
            extended[row][column] = "*";
            guessedMines.put(row, column);
        } else if (freeOrMine.equals("free")) {
            extended[row][column] = "/";
            exploreCells(filedShowingMines);
            clearFreeMines();
        }

           // gameView.setGameField(extended);
          //  gameView.displayField();

            String coordinatesString;
            String[] coordinatesArray;

            boolean isSolved = false;

            gameView.setGameField(extended);
            gameView.displayField();



            while (!isSolved) {
                System.out.println("Set/unset mines marks or claim a cell as free: ");
                coordinatesString = Main.reader.readLine();
                coordinatesArray = coordinatesString.split(" ");
                column = Integer.parseInt(coordinatesArray[0]) - 1;
                row = Integer.parseInt(coordinatesArray[1]) - 1;
                freeOrMine = coordinatesArray[2];

                if (freeOrMine.equals("mine")) {
                    if (extended[row][column].equals("*")) {
                      extended[row][column] = ".";
                      guessedMines.remove(row, column);
                    } else if (extended[row][column].equals(".")) {
                        extended[row][column] = "*";
                        guessedMines.put(row, column);
                    }
                    gameView.setGameField(extended);
                    gameView.displayField();
                } else if (freeOrMine.equals("free")) {
                    if (filedShowingMines[row][column].equals("*")) {
                        Iterator minesIterator = mines.entrySet().iterator();
                        while (minesIterator.hasNext()) {
                            Map.Entry mapElement = (Map.Entry)minesIterator.next();
                            row = (int) mapElement.getKey();
                            column =  (int) mapElement.getValue();
                            extended[row][column] = "X";
                        }
                        gameView.setGameField(extended);
                        gameView.displayField();
                        System.out.println("You stepped on a mine and failed!");
                                isSolved = true;

                    } else {
                        extended[row][column] = filedShowingMines[row][column];

                            exploreCells(filedShowingMines);
                            clearFreeMines();
                            gameView.setGameField(extended);
                            gameView.displayField();

                    }
                }


                if (guessedMines.equals(mines)) {
                    gameView.displayField();
                    System.out.println("Congratulations! You found all mines!");
                    isSolved = true;
                }

            }

        }

    }





