package g_Recursion.e_Subsets_Permutation_BackTracking;

public class d1_Maze_All_Directions {
    public static void main(String[] args) {

        Boolean[][] Maze = {{true, true, true},
                            {true, true, true},
                            {true, true, true}};

        Maze_all_Direction( "", 0, 0, Maze);
    }

    static void Maze_all_Direction( String path, int row, int col, Boolean[][] Maze){

        if( row == Maze.length-1 && col == Maze[0].length-1 ){
            System.out.println( path );
            return;
        }

        // Condition for making sure we are not going to the calls we have already visited
        if ( Maze[row][col] == false ){
            return;
        }

        // making the visited cells false so that we do not again access it
        Maze[row][col] = false;

        if ( row < Maze.length-1 ){
            Maze_all_Direction( path + "D", row+1, col, Maze);
        }
        if ( col < Maze[0].length-1 ){
            Maze_all_Direction( path + "R", row, col+1, Maze);
        }
        if( row > 0 ){
            Maze_all_Direction( path + "U", row-1, col, Maze);
        }
        if( col > 0 ){
            Maze_all_Direction( path + "L", row, col-1, Maze);
        }

        // This is the line where the function will be over
        // So before the function gets removed
        // Also remove the changes made by that function
        Maze[row][col] = true;
    }
}
