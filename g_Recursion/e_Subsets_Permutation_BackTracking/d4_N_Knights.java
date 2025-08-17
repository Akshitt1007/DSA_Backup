package g_Recursion.e_Subsets_Permutation_BackTracking;

public class d4_N_Knights {
    public static void main(String[] args) {

        int n = 3;
        boolean[][] board = new boolean[n][n];

        int knight = 4;

        Knights( board, 0, 0, knight );
    }

    static void Knights( boolean[][] board, int row, int col, int knight ){

        if ( knight == 0 ){

            display( board );
            System.out.println();
            return;
        }

        if ( row == board.length-1 && col == board.length ){
            return;
        }

        if ( col == board.length ){
            Knights( board, row+1, 0, knight );
            return;
        }

        if ( isSafe(board, row, col ) ){

            board[row][col] = true;
            Knights( board, row, col+1, knight-1 );

            board[row][col] = false;
        }

        Knights( board, row, col+1, knight );

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        // UP-LEFT
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        // LEFT -UP
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        // UP-RIGHT
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        // RIGHT-UP
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    static void display(boolean[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j]) {
                    System.out.print("K ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
