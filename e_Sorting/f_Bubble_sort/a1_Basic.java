package e_Sorting.f_Bubble_sort;

import java.util.Arrays;

public class a1_Basic {
    public static void main(String[] args) {

        int[] array_1 = { 3, 2, 5, 4, 1};
        int[] array_2 = { 5, 4, 3, 2, 1};
        int[] array_3 = { 1, 2, 3, 4, 5};

        System.out.println(Arrays.toString( bubble_sort( array_1 ) ));
        System.out.println(Arrays.toString( bubble_sort( array_2 ) ));
        System.out.println(Arrays.toString( bubble_sort( array_3 ) ));

    }

    // In Bubble Sort,
        // during each outer loop iteration (i),
        // the largest unsorted element "bubbles up" to its correct position at the end of the array.
        // So, after each pass, the last i elements are already sorted.
        // Therefore, in the inner loop (j), we iterate only up to (length - i - 1),
        // because there's no need to compare the already sorted elements at the end.

    static int[] bubble_sort ( int[] array ){

        boolean swapped ;
        for ( int i = 0 ; i < array.length-1 ; i++ ){

            swapped = false;
            // this is to check for the array that is already sorted

            for ( int j = 0 ; j < array.length-1-i ; j++){

                if ( array[j] > array[j+1] ){
                    swap ( array , j ,j+1 );

                    swapped = true;
                    // The swapped will be true if the swap method takes place meaning there occurred a swap meaning it was not already sorted
                }
            }

            if ( swapped == false ){
                // If the swapped remain false means its didn't pass the swap method meaning it is already sorted
                break;
            }
        }
        return array;
    }

    static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}

/*
    Why is the return type of bubble_sort an int[]?

    ->  Even though Bubble Sort sorts the array in-place, the method is returning int[] just to give back the same modified array (the sorted version).

        ✅ In-place + Return = Convenience
            1) The array is being sorted in-place — meaning, the original array passed as an argument is modified directly.

            2) But returning it makes the method more flexible:
                i)  You can use it inline with System.out.println(Arrays.toString(...))
                ii) It allows for method chaining if needed in future logic.

    Can we make the return type of bubble_sort a void ?

    ->  You can totally make the bubble_sort method void,
        because the sorting happens in-place — meaning the original array itself gets modified.

 */
