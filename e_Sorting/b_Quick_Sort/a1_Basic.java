package e_Sorting.b_Quick_Sort;

import java.util.Arrays;

public class a1_Basic {
    public static void main(String[] args) {
        // Test array to be sorted
        int[] array = { 3, 2, 4, 1, 6, 5 };

        // Call the quick sort function
        quick_sort( array );

        // Print the sorted array
        System.out.println(Arrays.toString( array ));
    }

    // Wrapper function that initializes the recursive sorting process
    static void quick_sort( int[] arr ){
        sort( arr, 0, arr.length-1 );
    }

    // Main recursive quicksort function
    static void sort( int[]arr, int low , int high ){
        // Base condition: if array has 0 or 1 elements, it's already sorted
        if( low >= high ){
            return;
        }

        // Initialize pointers for partitioning
        int start = low;
        int end = high;

        // Select the middle element as pivot
        int mid = ( start + end ) / 2;
        int pivot = arr[mid];   // we are taking pivot as the middle element of the array

        // First while loop handles the overall partitioning process
        while ( start <= end ){
            // Find element on left side that should be on right side of pivot
            while ( arr[start] < pivot ){
                start++;
            }

            // Find element on right side that should be on left side of pivot
            while ( arr[end] > pivot ){
                end--;
            }

            if ( start <= end ) {
                // Swap elements that are on the wrong sides of pivot
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                // Move pointers after swap
                start++;
                end--;
            }
        }

        // At this point:
        // - All elements from low to end are <= pivot
        // - All elements from start to high are >= pivot

        // Recursively sort the left subarray
        sort( arr, low, end );
        // Recursively sort the right subarray
        sort( arr, start, high );

        /*

            why not used :
                        sort(arr, low, mid);     // includes mid
                        sort(arr, mid + 1, high);

            -> mid+1 and mid-1 doesn't mean before the pivot element since it's moved, but end would be before the pivot element
               because it's moving according to the pivot element?"

                1) In merge sort, mid-1 and mid+1 are based on index math, not data movement.
                2) In quick sort, the array is partitioned around a pivot, so pivotIndex - 1 actually refers to the last element that is less than pivot,
                   and pivotIndex + 1 is the first element greater than pivot.
                3) So yes, in quick sort, your end (if you define it as pivotIndex - 1) would be before the pivot.
         */
    }
}
