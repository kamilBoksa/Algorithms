package com.company;

import java.util.Random;

public class FieldGenerator {
    private static final int firstRowIndex = 0;
    private static final char mineSign = '*';
    private static final char emptySign = '.';

    public char[][] getMineField(int rows, int columns) {
        char[][] minefield = new char[rows][columns];
        int minesAmount = 5;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                minefield[x][y] = '.';
            }
        }
        placeMinesInMinefield(minefield, minesAmount);
        return minefield;
    }

    public void printMineField(char[][] mineField) {
        for (char[] row : mineField) {
            for(char column : row) {
                System.out.print(column);
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    private void placeMinesInMinefield(char[][] minefield, int minesAmount) {
        Random indexGenerator = new Random();
        int counter = 0;

        while(minesAmount > counter) {
            int x = indexGenerator.nextInt(minefield.length);
            int y = indexGenerator.nextInt(minefield[firstRowIndex].length);
            if(minefield[x][y] == emptySign) {
                minefield[x][y] = mineSign;
                counter ++;
            }
        }
    }
}
