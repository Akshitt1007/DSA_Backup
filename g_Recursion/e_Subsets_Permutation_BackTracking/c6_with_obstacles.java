package g_Recursion.e_Subsets_Permutation_BackTracking;

public class c6_with_obstacles {
    public static void main(String[] args) {

        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathRestrictions("", board, 0, 0);

        System.out.println();

        Maze_with_obstacle("", 0, 0 );
    }

    // Using a boolean array and only going right/down
    static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (maze[r][c]==false) {
            return;
        }

        if (r < maze.length - 1) {
            pathRestrictions(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            pathRestrictions(p + 'R', maze, r, c+1);
        }
    }

    // right/down/diagonal
    static void Maze_with_obstacle( String path, int row, int col ){

        /*
            _ _ _
            _ x _
            x _ _

            x are the obstacle here
         */

        if ( row == 2 && col == 2 ){
            System.out.println( path );
            return;
        }

        if ( row == 1 && col == 1 ){    // Obstacle at 1,1
            return;
        }
        if ( row == 2 && col == 0 ){    // Obstacle at 2,0
            return;
        }

        if ( row < 2 ){
            Maze_with_obstacle( path+'D', row+1, col );
        }

        if ( col < 2 ){
            Maze_with_obstacle( path+'R', row, col+1 );
        }

        if ( row < 2 && col < 2 ){
            Maze_with_obstacle( path+"d", row+1, col+1 );
        }
    }
}
