package com.company;

public class Main {

    public static void main(String[] args) {
        handleMinesweeper();
    }

    private static void handleMinesweeper() {
        FieldGenerator generator = new FieldGenerator();
        FieldSolver solver = new FieldSolver();

        int rows = 9;
        int columns = 9;
        char[][] field = generator.getMineField(rows,columns);
        generator.printMineField(field);

        field = solver.solveMineField(field);
        generator.printMineField(field);
    }
}
