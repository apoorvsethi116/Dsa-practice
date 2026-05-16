package Recursion;

public class SudokuSolver {

    public static boolean solveSudoku(int[][] board, int row, int col) {

        // If reached end of row, move to next row
        if (row == 9) {
            return true; // solved
        }

        // Calculate next cell
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If cell already filled, move ahead
        if (board[row][col] != 0) {
            return solveSudoku(board, nextRow, nextCol);
        }

        // Try placing digits 1 to 9
        for (int digit = 1; digit <= 9; digit++) {

            // Check if placing digit is safe
            if (isSafe(board, row, col, digit)) {

                // STEP 1: Place the digit
                board[row][col] = digit;

                // STEP 2: Recurse for next cell
                if (solveSudoku(board, nextRow, nextCol)) {
                    return true; // solution found
                }

                // STEP 3: Backtrack (undo the move)
                board[row][col] = 0;
            }
        }

        // No valid digit found → backtrack
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int digit) {

        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true; // safe to place
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] board = {
                {0,0,8,0,0,0,0,0,0},
                {4,9,0,1,5,7,0,0,2},
                {0,0,3,0,0,4,1,9,0},
                {1,8,5,0,6,0,0,2,0},
                {0,0,0,0,2,0,0,6,0},
                {9,6,0,4,0,5,3,0,0},
                {0,3,0,0,7,2,0,0,4},
                {0,4,9,0,3,0,0,5,7},
                {8,2,7,0,0,9,0,1,3}
        };

        if (solveSudoku(board, 0, 0)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}
