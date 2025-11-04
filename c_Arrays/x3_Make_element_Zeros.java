package c_Arrays;

import java.util.Arrays;

public class x3_Make_element_Zeros {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 6}, { 12, 0, 4}, {31, 1, 1}} ;

        boolean[][] array = new boolean[matrix.length][matrix[0].length];

        make_zero( matrix, array );

        for ( int i = 0 ; i< matrix.length ; i++){
            System.out.println( Arrays.toString( matrix[i] ));
        }
    }

    static void make_zero( int[][] arr, boolean[][] a ){

        for ( int i=0 ; i < arr.length ; i++ ){
            for ( int j=0 ; j < arr[i].length ; j++ ){
                if ( arr[i][j] == 0 ){
                    a[i][j] = true;
                }
            }
        }

        for ( int i = 0 ; i < a.length ; i++ ){
            for ( int j = 0 ; j < a[i].length ; j++ ){
                if ( a[i][j]  ){
                    zero( arr, i, j );
                }
            }
        }
    }

    static void zero ( int[][] arr, int row, int col ){

        for ( int i = 0 ; i < arr.length ; i++ ){
            arr[i][col] = 0;
        }

        for ( int i = 0 ; i < arr.length ; i++ ){
            arr[row][i] = 0;
        }
    }
}