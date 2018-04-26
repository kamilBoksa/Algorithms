package com.company;

public class FieldSolver {
    private static final int firstRowIndex = 0;
    private static final char mineSign = '*';

    public char[][] solveMineField(char[][] minefield) {

        for(int x = 0; x < minefield.length; x++) {
            for(int y = 0; y < minefield[firstRowIndex].length; y++) {
                getMinesAroundPosition(minefield, x, y);
            }
        }
        return minefield;
    }

    private void getMinesAroundPosition(char[][] minefield, int x, int y) {
        int minesAmount = 0;
        if(minefield[x][y] != mineSign) {
            if(x+1 < minefield.length && minefield[x+1][y] == mineSign){
                minesAmount ++;
            }
            if(x>0 && x-1 < minefield.length && minefield[x-1][y] == mineSign){
                minesAmount ++;
            }
            if(y+1 < minefield[firstRowIndex].length && minefield[x][y+1] == mineSign){
                minesAmount ++;
            }
            if(y > 0 && y-1 < minefield[firstRowIndex].length && minefield[x][y-1] == mineSign){
                minesAmount ++;
            }
            if(x+1 < minefield.length && y+1 < minefield[firstRowIndex].length && minefield[x+1][y+1] == mineSign){
                minesAmount ++;
            }
            if(x>0 && y>0 && y-1 < minefield[firstRowIndex].length && x-1 < minefield.length && minefield[x-1][y-1] == mineSign){
                minesAmount ++;
            }
            if(y > 0 && y-1 < minefield[firstRowIndex].length && x+1 < minefield.length && minefield[x+1][y-1] == mineSign){
                minesAmount ++;
            }
            if(x>0 && y+1 < minefield[firstRowIndex].length && x-1 < minefield.length && minefield[x-1][y+1] == mineSign){
                minesAmount ++;
            }
            minefield[x][y] = (char)('0' + minesAmount);
        }
    }
}
