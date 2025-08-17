package g_Recursion;

import java.util.Arrays;

public class x2_Selection_Sort {
    public static void main(String[] args) {

        int[] array_1 = { 3, 2, 5, 4, 1};
        int[] array_2 = { 5, 4, 3, 2, 1};
        int[] array_3 = { 1, 2, 3, 4, 5};

        selection_sort( array_1 );
        System.out.println(Arrays.toString( array_1 ) );

        selection_sort( array_2 );
        System.out.println(Arrays.toString( array_2 ) );

        selection_sort( array_3 );
        System.out.println(Arrays.toString( array_3 ) );

    }

    static void selection_sort( int[] arr ){
        helper( arr, arr.length, 0, 0 );
    }

    static void helper( int[]arr, int row, int col, int max_index ){

        if ( row == 0 ){
            return;
        }

        if( col < row ){

            if( arr[col] > arr[max_index] ){

                helper( arr, row, col+1, col);
            }
            else{

                helper( arr, row, col+1, max_index );
            }
        }
        else{
            swap_element( arr, row-1, max_index);

            helper( arr, row-1, 0 , 0);
        }
    }

    static void swap_element ( int[]array , int i , int j){

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;                    // Putting the last value of arr in the position of max element index

    }
}
