package g_Recursion.e_Subsets_Permutation_BackTracking;

public class d5_printing_sudoku_box {
    public static void main(String[] args) {

        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        print( sudoku ,7,7);
    }

    static void print( int[][] sudoku, int r, int c){

        /*
            | Goal              | Fix | Vary | Use Length Of        |
            | ----------------- | --- | ---- | -------------------- |
            | Scan a row (→)    | row | col  |  sudoku[row].length  |
            | Scan a column (↓) | col | row  |  sudoku.length       |
         */

        // Printing column wise
        for ( int i = 0 ; i< sudoku.length; i++ ){
            System.out.println( sudoku[i][c]);
        }

        // printing row wise
        for ( int i=0 ; i< sudoku.length ; i++ ){
            System.out.print( sudoku[r][i]);
        }
        System.out.println();

        /*

        0 0 0 | 1 1 1 | 2 2 2
        0 0 0 | 1 1 1 | 2 2 2
        0 0 0 | 1 1 1 | 2 2 2
        ---------------------
        3 3 3 | 4 4 4 | 5 5 5
        3 3 3 | 4 4 4 | 5 5 5
        3 3 3 | 4 4 4 | 5 5 5
        ---------------------
        6 6 6 | 7 7 7 | 8 8 8
        6 6 6 | 7 7 7 | 8 8 8
        6 6 6 | 7 7 7 | 8 8 8


            We want to print the 3x3 box (subgrid) in which the cell (r, c) lies.

            Sudoku is a 9x9 grid divided into nine 3x3 blocks.
            Each block always starts at a row and column index which is a multiple of 3:
            e.g., (0,0), (0,3), (0,6), (3,0), ..., (6,6)

            To find the starting cell of the block:
            - r % 3 gives how many rows down we are inside the block
            - c % 3 gives how many columns right we are inside the block

            So we subtract that offset to reach the block’s top-left corner:
            - row = r - (r % 3)
            - col = c - (c % 3)

            This gives us the correct starting point to print the 3x3 box.
        */

        int row = r - (r % 3 );
        int col = c - (c % 3 );


        int row_end = row+3;
        int col_end = col+3;

        for ( int i = row ; i < row_end ; i ++ ){
            for ( int j = col ; j < col_end ; j++ ){
                System.out.print( sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
