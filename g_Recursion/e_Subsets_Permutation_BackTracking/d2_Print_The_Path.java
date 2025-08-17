package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.Arrays;

public class d2_Print_The_Path {
    public static void main(String[] args) {

        Boolean[][] Maze = {{true, true, true},
                            {true, true, true},
                            {true, true, true}};

        int[][] array = {{0,0,0},
                         {0,0,0},
                         {0,0,0}};

        Print_the_path( "", 0, 0, Maze, 1, array);
    }

    static void Print_the_path( String path, int row, int col, Boolean[][] Maze, int step, int[][] map){

        if ( row == Maze.length-1 && col == Maze[0].length-1 ){

            map[row][col] = step;   // For the last step

            for( int[] arr : map ){
                System.out.println( Arrays.toString(arr) );
            }
            System.out.println( path );

            System.out.println();
            return;
        }

        if( !Maze[row][col] ){
            return;
        }

        Maze[row][col] = false;

        map[row][col] = step;

        if ( row < Maze.length-1 ){
            Print_the_path( path + "D", row+1, col, Maze, step+1, map );
        }
        if ( col < Maze[0].length-1 ){
            Print_the_path( path + "R", row, col+1, Maze, step+1, map );
        }
        if( row > 0 ){
            Print_the_path( path + "U", row-1, col, Maze, step+1, map );
        }
        if( col > 0 ){
            Print_the_path( path + "L", row, col-1, Maze, step+1, map );
        }

        map[row][col] = 0;

        Maze[row][col] = true;
    }
}
