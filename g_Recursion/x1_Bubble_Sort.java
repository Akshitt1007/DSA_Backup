package g_Recursion;

import java.util.Arrays;

public class x1_Bubble_Sort {
    public static void main(String[] args) {

        int[] array_1 = { 3, 2, 5, 4, 1};
        int[] array_2 = { 5, 4, 3, 2, 1};
        int[] array_3 = { 1, 2, 3, 4, 5};

        bubble_sort( array_1 );
        System.out.println(Arrays.toString( array_1 ) );

        bubble_sort( array_2 );
        System.out.println(Arrays.toString( array_2 ) );

        bubble_sort( array_3 );
        System.out.println(Arrays.toString( array_3 ) );

    }

    static void bubble_sort( int[]arr ){
        helper( arr, 0 , 0 );
    }

    /*
     * Recursively implements bubble sort
     * arr The array to sort
     * index Current position in the current pass
     * sortedCount Number of elements that are already sorted at the end
     */

    static void helper( int[] arr, int index, int sortedCount ){

        // Base case: All elements are sorted
        if ( sortedCount == arr.length-1 ){
            return;
        }

        // Current pass is complete, start a new pass with one more element sorted
        if ( index == arr.length-1-sortedCount ){
            helper( arr, 0 , sortedCount+1 );
            return;
        }

        // Compare adjacent elements and swap if needed
        if ( arr[index] > arr[index+1] ){
            swap ( arr, index , index+1 );
        }

        // Move to the next position in the current pass
        helper( arr, index+1 , sortedCount );
    }

    static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
