package e_Sorting.c_Cycle_sort;

import java.util.Arrays;

// https://leetcode.com/problems/first-missing-positive/submissions/

public class a6_First_Missing_Positive {
    public static void main(String[] args) {

        int[] array_0 = { 1, 2, 0 };
        int[] array_1 = { 3, 4, -1, 1 };
        int[] array_2 = { 7, 8, 9, 11, 12 };
        int[] array_3 = { 1 };

        System.out.println( first_missing_positive( array_0) );
        System.out.println( first_missing_positive( array_1) );
        System.out.println( first_missing_positive( array_2) );
        System.out.println( first_missing_positive( array_3) );

        System.out.println( Arrays.toString( array_1 ) );
        System.out.println( Arrays.toString( array_0 ) );
    }

    static int first_missing_positive( int[] arr ) {

        int i = 0;

        while (i < arr.length) {

            int index = arr[i] - 1;

            if (arr[i] > 0 && arr[i] < arr.length && arr[i] != arr[index]) {

                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

            }
            else {
                i++;
            }
        }

        for ( int j = 0 ; j < arr.length ; j++ ){
            if ( arr[j] != j+1 ){
                return j+1 ;
            }
        }

        return arr.length + 1 ;

    }
}
