package Recursion;

public class SudokoSolver {
    // Function to check if placing char c at board[row][col] is valid
    public boolean isValid(char[][] board, int row, int col, char c) {
        // Check current column for duplicates
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }

        // Check current row for duplicates
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) return false;
        }

        // Find start of 3x3 sub-box
        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (col / 3);

        // Check 3x3 box for duplicates
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == c) return false;
            }
        }

        // No conflicts, placement is valid
        return true;
    }

    // Recursive backtracking to solve Sudoku
    public boolean solveSudoku(char[][] board) {
        // Traverse all cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If cell is empty
                if (board[i][j] == '.') {
                    // Try all digits
                    for (char c = '1'; c <= '9'; c++) {
                        // Check if placing c is valid
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // place c

                            // Recurse to solve rest
                            if (solveSudoku(board)) return true;

                            // Backtrack if needed
                            board[i][j] = '.';
                        }
                    }
                    // If no number fits, backtrack
                    return false;
                }
            }
        }
        // All cells filled correctly
        return true;
    }



    public static void main(String[] args) {
        char[][] board = {
            {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
            {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
            {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
            {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
            {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
            {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
            {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
            {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
            {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        SudokoSolver sol = new SudokoSolver();
        sol.solveSudoku(board);

        // Print solved board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
