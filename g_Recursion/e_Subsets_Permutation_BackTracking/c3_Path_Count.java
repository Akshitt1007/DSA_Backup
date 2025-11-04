package g_Recursion.e_Subsets_Permutation_BackTracking;

public class c3_Path_Count {
    public static void main(String[] args) {

        System.out.println( check( 3, 3) );
    }

    static int check ( int row , int col ){

        if ( col == 1 || row == 1 ){
            return 1 ;
        }

        int left = check( row-1, col );
        int right = check( row, col-1);

        int count = left + right;

        return count;
    }
}
