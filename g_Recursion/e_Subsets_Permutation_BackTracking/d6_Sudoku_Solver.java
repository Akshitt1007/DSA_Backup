package g_Recursion.e_Subsets_Permutation_BackTracking;

public class d6_Sudoku_Solver {
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

        if ( solve(sudoku) ){
            display ( sudoku );
        }
        else {
            System.out.println( "Sudoku not solvable");
        }
    }

    static boolean solve( int[][] sudoku ){

        int n = sudoku.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for ( int i=0 ; i<sudoku.length ; i++ ){
            for ( int j=0 ; j<sudoku.length ; j++ ){

                if ( sudoku[i][j] == 0 ){

                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if ( emptyLeft == false ){
                break;
            }
        }
        if ( emptyLeft == true ){
            return true;
        }

        for ( int number = 1 ; number <= 9 ; number++ ){

            if ( isSafe(sudoku, row, col, number) ){
                sudoku[row][col] = number;

                if ( solve(sudoku)){
                    return true;
                }
                else{
                    sudoku[row][col] = 0;
                }
            }
        }

        return false;
    }

    static boolean isSafe( int[][] sudoku, int row, int col, int number ){

        // Vertical check | column wise
        for ( int i = 0 ; i < sudoku.length ; i++ ){

            // check if the number is already in the row or not
            if ( sudoku[i][col] == number ){
                return false;
            }
        }

        // Horizontal check - row wise
        for ( int i = 0 ; i < sudoku.length ; i++ ){

            if ( sudoku[row][i] == number ){
                return false;
            }
        }

        // 3x3 box check
        int r_start = row - (row % 3 );
        int c_start = col - (col % 3 );

        int row_end = r_start+3;
        int col_end = c_start+3;

        for ( int i = r_start ; i < row_end ; i ++ ){
            for ( int j = c_start ; j < col_end ; j++ ){

                if ( sudoku[i][j] == number ){
                    return false;
                }
            }
        }

        return true;
    }


    static void display( int[][] sudoku_board ){

        for ( int i=0 ; i< sudoku_board.length ; i++ ){
            for ( int j=0 ; j<sudoku_board[i].length ; j++ ){
                System.out.print( sudoku_board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
