package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.ArrayList;

public class c5_with_Diagonal {
    public static void main(String[] args) {

        System.out.println( Maze_path_with_RD_Diagonal_Count(3, 3 ) );

        Maze_path_with_RD_Diagonal( "", 3, 3);

        System.out.println( Maze_path_with_RD_Diagonal_List( "", 3, 3 ));
    }

    static int Maze_path_with_RD_Diagonal_Count( int row, int col ){

        if ( col == 1 || row == 1 ){
            return 1 ;
        }

        int right = Maze_path_with_RD_Diagonal_Count(  row-1, col);
        int down = Maze_path_with_RD_Diagonal_Count(  row, col-1);
        int diagonal = Maze_path_with_RD_Diagonal_Count( row-1, col-1);

        int count = right + down + diagonal;

        return count;
    }


    static void Maze_path_with_RD_Diagonal( String path, int row, int col ){

        if ( col == 1 && row == 1 ){
            System.out.println( path );
            return;
        }

        if ( row > 1 ){
            Maze_path_with_RD_Diagonal( path+'D', row-1, col );
        }

        if ( col > 1 ){
            Maze_path_with_RD_Diagonal( path+'R', row, col-1 );
        }
        if ( col > 1 && row > 1 ){
            Maze_path_with_RD_Diagonal( path+'d', row-1, col-1 );
        }
    }

    static ArrayList<String> Maze_path_with_RD_Diagonal_List(String p, int row, int col ) {

        ArrayList<String> list = new ArrayList<>();

        if (col == 1 && row == 1) {
            list.add(p);
            return list;
        }

        if (row > 1) {
            list.addAll(Maze_path_with_RD_Diagonal_List(p + 'D', row - 1, col));
        }

        if (col > 1) {
            list.addAll(Maze_path_with_RD_Diagonal_List(p + 'R', row, col - 1));
        }

        if (col > 1 && row > 1) {
            list.addAll(Maze_path_with_RD_Diagonal_List(p + 'd', row - 1, col - 1));
        }

        return list;
    }
}
