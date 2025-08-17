package d_Searching.Binary_Search;

public class b13_Number_Of_Rotation {
    public static void main(String[] args) {
        int [] arr_1 = {7,8,9,0,1,2,3,4,5,6};
        int [] arr_2 = {0,1,2,3,4,5,6,7,8,9};
        int [] arr_3 = {1,2,3,4,5,6,7,8,9,0};
        int [] arr_4 = {2,9,2,2,2};
        int [] arr_5 = {2,2,2,2,2};  // Edge case (all duplicates)

        System.out.println("Number of rotations: " + rotationCount(arr_1)); // Expected: 3
        System.out.println("Number of rotations: " + rotationCount(arr_2)); // Expected: 0
        System.out.println("Number of rotations: " + rotationCount(arr_3)); // Expected: 9
        System.out.println("Number of rotations: " + rotationCount(arr_4)); // Expected: 2
        System.out.println("Number of rotations: " + rotationCount(arr_5)); // Expected: 0
    }

    static int rotationCount(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: If array is already sorted, rotation count is 0
            if (arr[start] < arr[end]) {
                return start;
            }

            // Case 2: Check if mid is the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid;
            }

            // Case 3: Handle duplicates by skipping
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
                continue;
            }

            // Case 4: Decide search direction
            if (arr[mid] >= arr[start]) {
                start = mid + 1; // Move to right half
            } else {
                end = mid - 1; // Move to left half
            }
        }
        return 0; // If array is not rotated
    }
}
