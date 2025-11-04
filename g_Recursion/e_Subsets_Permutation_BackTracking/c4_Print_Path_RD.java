package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.ArrayList;

public class c4_Print_Path_RD {
    public static void main(String[] args) {

        Maze_paths("", 3, 3) ;

        System.out.println( Maze_paths_List( "", 3, 3));

    }

    static void Maze_paths( String p, int row, int col ){

        if ( col == 1 && row == 1 ){
            System.out.println( p );
            return;
        }

        if ( row > 1 ){
            Maze_paths( p+'D', row-1, col);
        }

        if ( col > 1 ){
            Maze_paths( p+'R', row, col-1);
        }

    }

    static ArrayList<String> Maze_paths_List( String p, int row, int col ){

        ArrayList<String> list = new ArrayList<>();

        if ( col == 1 && row == 1 ){
            list.add( p );
            return list ;
        }

        if ( row > 1 ){
            list.addAll( Maze_paths_List( p+'D', row-1, col) );
        }

        if ( col > 1 ){
            list.addAll( Maze_paths_List( p+'R', row, col-1) );
        }

        return list;
    }
}
