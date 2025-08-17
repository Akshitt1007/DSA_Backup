package d_Searching.Binary_Search;

/*
    LeetCode 1095.
    In this Question,

    we have to return the index of the target element in a bitonic array

    eg:

    1) array = [ 0, 1, 2, 3, 4, 5, 4, 3, 2, 1,];
    target = 4

    index could be either 4 or 6
    but return min index ie 4

    2) array = [ 0, 1, 2, 3, 5, 4, 3, 2, 1,];
    target = 4

    return index 6


    in such question :
            a) first find the peak index in the array
            b) then create two array like ascending and descending
            c) first check in ascending part where start = 0 to end = peak ; if it contains the target then return it
            d) else check in descending part where start = peak and end = array.length-1.
 */

public class b9_Target_in_Bitonic_array {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 3;

        System.out.print(search_range(array, target));
    }

    static int search_range(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (arr[start] < arr[end]) {
            int new_start = end + 1;

            end = end + (end - start + 1) * 2;

            start = new_start;
        }
        return result(arr, start, end, target);
    }

    static int result(int[] array, int start, int end, int target) {

        int peak = peak_index(array, start, end);

        int answer = target_index(array, 0, peak, target, true);

        if (answer != -1) {
            return answer;
        } else {
            return target_index(array, peak, end, target, false);
        }
    }

    static int target_index(int[] arr, int start, int end, int target, boolean side) {

        if (side == true) {

            while (start <= end) {
                int middle = start + (end - start) / 2;

                if (arr[middle] < target) {
                    start = middle + 1;
                } else if (arr[middle] > target) {
                    end = middle - 1;
                } else {
                    return middle;
                }
            }
        }
        else if (side == false) {

            while (start <= end) {
                int middle = start + (end - start) / 2;

                if (arr[middle] > target) {
                    end = middle + 1;
                } else if (arr[middle] < target) {
                    start = middle - 1;
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }

    static int peak_index(int[] arr, int start, int end) {

        while (start < end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] < arr[middle + 1]) {
                start = middle + 1;
            } else if (arr[middle] > arr[middle + 1]) {
                end = middle;
            }
        }
        return start;
    }
}



