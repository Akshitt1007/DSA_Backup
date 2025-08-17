package g_Recursion.e_Subsets_Permutation_BackTracking;

public class d3_N_Queens {
    public static void main(String[] args) {

        int n = 4; // Number of queens to place (and size of the board)

        boolean[][] board = new boolean[n][n];

        System.out.println( Queen(board, 0) ); // Start placing queens from row 0
    }

    static int Queen(boolean[][] board, int row) {

        // Base case: if all rows are processed, we found one valid arrangement
        if (row == board.length) {
            display(board); // Display the board configuration
            System.out.println();
            return 1; // Return 1 to count this valid arrangement
        }

        // this is not know how many solutions are there
        int count = 0;

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {

            // Check if placing the queen at (row, col) is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Place the queen

                count = count + Queen(board, row + 1); // Recursively place queens in the next row

                board[row][col] = false; // Backtrack: Remove the queen
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {

        // Check for vertical conflicts in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) { // If another queen is already in the column
                return false;
            }
        }

        // Check for conflicts in the left diagonal
        int maxLeft = Math.min(row, col); // Maximum steps possible in the left diagonal

        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) { // If another queen is found in the left diagonal
                return false;
            }
        }

        // Check for conflicts in the right diagonal
        int maxRight = Math.min(row, board.length - col - 1); // Maximum steps possible in the right diagonal

        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) { // If another queen is found in the right diagonal
                return false;
            }
        }

        // If no conflicts are found, the position is safe for placing a queen
        return true;
    }

    static void display(boolean[][] board) {

        // Loop through each cell of the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                // Print 'Q' if a queen is placed, otherwise print '_'
                if (board[i][j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

}