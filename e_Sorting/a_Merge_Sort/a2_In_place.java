package e_Sorting.a_Merge_Sort;

import java.util.Arrays;

public class a2_In_place {
    public static void main(String[] args) {
        int[] array = { 5, 4, 3, 2, 1, 2 };

        help(array);
        System.out.println(Arrays.toString(array));
    }

    // Helper function to initiate the merge sort process
    static void help(int[] arr) {
        // Call the actual merge sort function with initial range (0 to length of array)
        mergeSortInPlace(arr, 0, arr.length);
    }

    // Main recursive merge sort function
    // Parameters:
    // - arr: the array to sort
    // - s: start index (inclusive)
    // - e: end index (exclusive)
    static void mergeSortInPlace(int[] arr, int s, int e) {
        // Base case: if segment size is 1 or less, it's already sorted
        if (e - s == 1) {
            return;
        }

        // Calculate middle point to divide the array into two halves
        int mid = (s + e) / 2;

        // Recursively sort the left half (from s to mid)
        mergeSortInPlace(arr, s, mid);

        // Recursively sort the right half (from mid to e)
        mergeSortInPlace(arr, mid, e);

        // Merge the two sorted halves
        mergeInPlace(arr, s, mid, e);
    }

    // Function to merge two sorted segments of the array
    // Parameters:
    // - arr: the original array
    // - s: start index of first segment
    // - m: middle index (end of first segment and start of second segment)
    // - e: end index of second segment
    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        // Create a temporary array to hold the merged result
        // Size is the length of the combined segments
        int[] mix = new int[e - s];

        // Initialize pointers for both segments and the temporary array
        int i = s;      // pointer for the first segment (s to m-1)
        int j = m;      // pointer for the second segment (m to e-1)
        int k = 0;      // pointer for the temporary array

        // Compare elements from both segments and add smaller one to temporary array
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                // If element from first segment is smaller
                mix[k] = arr[i];
                i++;    // Move first segment pointer
            } else {
                // If element from second segment is smaller or equal
                mix[k] = arr[j];
                j++;    // Move second segment pointer
            }
            k++;        // Move temporary array pointer
        }

        // Copy any remaining elements from the first segment
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the second segment
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged elements from temporary array back to the original array
        // Note: we copy to the original position (s+l) in the input array
        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
        /*
            working of line 89:

            1. The mix array now contains the merged and sorted elements from the two segments we were working with.

            2. We need to copy these sorted elements back to the original array at their correct positions.

            3. s is the starting index of the current segment in the original array.

            4. By doing arr[s+l] = mix[l], we're placing each element from mix back into the original array, but offset by s to ensure
               they go in the right position.

            5. After this loop completes, the segment of the original array from index s to index e-1 will be sorted.
        */
    }
}