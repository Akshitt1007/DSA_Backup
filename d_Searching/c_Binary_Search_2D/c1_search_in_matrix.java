package d_Searching.Binary_Search_2D;

public class c1_search_in_matrix {
    public static void main(String[] args) {

        int [][] array = new int[3][3];

        array = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 8;

        System.out.println( find_element(array, target));
    }
    static boolean find_element( int[][] arr, int target ){

        for ( int row = 0 ; row < arr.length ; row++ ){
            for ( int col = 0 ; col < arr[row].length ; col++ ){
                if ( arr[row][col] == target ){
                    return true;
                }
            }
        }
        return false;
    }
}
