package e_Sorting.a_Merge_Sort;

import java.util.Arrays;
/*
        Merge Sort:

            1) Divide the array into 2 parts
            2) Sort the both parts of array via recursion
            3) when get sorted
            4) merge both the sorted array

         Merge Sort Time Complexity:

            Time: O(n log n)
            Space: O(n) (for temporary arrays used in merging)


        Example: arr = [ 3, 2, 5, 6, 1, 8, 12, 9]

                    1) divide into two parts
                       arr1 = [ 3, 2, 5, 6 ] and arr2 = arr2 = [ 1, 8, 9, 12 ]

                    2) sort both the parts
                       arr1 = [ 2, 3, 5, 6 ] and arr2 = [ 1, 8, 9, 12 ]

                    3) merge them arr1 + arr2

                        we will point two pointer on the index[0] of both array

                        i) arr1 = [ 2, 3, 5, 6 ] and arr2 = [ 1, 8, 9, 12 ]
                                    p1                        p2

                                    p2 < p1 so p2 will get stored and p2 will move on
                                    arr = [ 1 ]

                        ii) arr1 = [ 2, 3, 5, 6 ] and arr2 = [ 1, 8, 9, 12 ]
                                    p1                            p2

                                    p1 < p2 => p1 will get stored and p1 will move on
                                    arr = [ 1, 2 ]

                        iii) arr1 = [ 2, 3, 5, 6 ] and arr2 = [ 1, 8, 9, 12 ]
                                         p1                        p2

                                         p1 < p2 => p1 stored and move on
                                         arr = [ 1, 2, 3 ]

                        iv) arr1 = [ 2, 3, 5, 6 ] and arr2 = [ 1, 8, 9, 12 ]
                                           p1                     p2

                                         p1 < p2 => p1 stored and move on
                                         arr = [ 1, 2, 3, 5 ]

                        v) arr1 = [ 2, 3, 5, 6 ] and arr2 = [ 1, 8, 9, 12 ]
                                             p1                  p2

                                         p1 < p2 => p1 stored and move on
                                         arr = [ 1, 2, 3, 5, 6 ]

                        vi) arr1 = [ 2, 3, 5, 6 ] and arr2 = [ 1, 8, 9, 12 ]
                                                                  p2

                                         since p1 is ended so Now, copy all remaining elements from arr2 starting from p2 to the final array.
                                         arr = [ 1, 2, 3, 5, 6, 8, 9, 12 ]
     */

public class a1_Code {
    public static void main(String[] args) {
        int[] array = { 2,1,0,2,1,0,2,1,0};

        System.out.println(Arrays.toString(merge_sort(array)));
    }

    static int[] merge_sort(int[] arr) {
        // Base case: If array has only one element, it's already sorted
        if (arr.length == 1) {
            return arr;
        }

        // Find the middle index to divide the array into two halves
        int mid = arr.length / 2;

        // Recursively sort the left half of the array
        // Arrays.copyOfRange creates a new array from index 0 (inclusive) to mid (exclusive)
        int[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));

        // Recursively sort the right half of the array
        // Arrays.copyOfRange creates a new array from index mid (inclusive) to arr.length (exclusive)
        int[] right = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));

        // Merge the two sorted halves and return the result
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        // Create a new array to hold the merged result
        // Size is the sum of both input arrays
        int[] mix = new int[left.length + right.length];

        // Initialize pointers for all three arrays
        int i = 0; // pointer for left array
        int j = 0; // pointer for right array
        int k = 0; // pointer for mix (result) array

        // Compare elements from both arrays and add the smaller one to mix
        // Continue until we reach the end of either array
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                // If left element is smaller, add it to mix
                mix[k] = left[i];
                i++; // Move left array pointer forward
            } else {
                // If right element is smaller or equal, add it to mix
                mix[k] = right[j];
                j++; // Move right array pointer forward
            }
            k++; // Move result array pointer forward
        }

        // If left array has remaining elements, add them all to mix
        // This happens when right array is exhausted first
        while (i < left.length) {
            mix[k] = left[i];
            k++;
            i++;
        }

        // If right array has remaining elements, add them all to mix
        // This happens when left array is exhausted first
        while (j < right.length) {
            mix[k] = right[j];
            k++;
            j++;
        }

        // Return the merged sorted array
        return mix;
    }
}