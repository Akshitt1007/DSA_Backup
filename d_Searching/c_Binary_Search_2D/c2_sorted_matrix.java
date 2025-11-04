package d_Searching.Binary_Search_2D;

import java.util.Arrays;

public class c2_sorted_matrix {
    public static void main(String[] args) {

//        int[][] arr = {{10, 20, 30, 40},
//                      { 12, 23, 38, 41},
//                      { 15, 27, 39, 45},
//                      { 17, 29, 40, 50}};

        int[][] arr = {{-1,3}};

        int target_1 = 3;
//        int target_2 = 51;

        for ( int row = 0 ; row < arr.length ; row++ ){
            for ( int col = 0 ; col < arr[row].length ; col++ ){
                System.out.print( arr[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println( "Target is present at " + Arrays.toString( find_target (arr, target_1) ));
//        System.out.println( "Target is present at " + Arrays.toString( find_target (arr, target_2) ));
    }

    static int[] find_target( int[][] arr, int target ){

        int row = 0;
        int col = arr[0].length-1;

        while ( row < arr.length && col >= 0 ){

            if ( arr[row][col] < target ){
                row ++;
            }
            else if ( arr[row][col] > target ){
                col --;
            }
            else{
                return new int[]{row,col} ;
            }
        }
        return new int[]{-1,-1};
    }
}
