package d_Searching.Binary_Search;

/*
        "The pivot is the point where the sorted order breaks, i.e., the highest element in a rotated sorted array.
        The pivot is the largest element, followed by the smallest element."

        array = [ 1, 2, 3, 4, 5, 7, 8, 9, 10 ]
            after one rotation
        array = [ 10, 1, 2, 3, 4, 5, 7, 8, 9 ]
            after second rotation
        array = [ 9, 10, 1, 2, 3, 4, 5, 7, 8 ]
            after third rotation
        array = [ 8, 9, 10, 1, 2, 3, 4, 5, 7 ]

        here it is rotated sorted array
        and at index 3 it is getting rotated

        the point at which the ascending order starts is known as Pivot Point

        here [8,9,10] and [1,2,3,4,5,7] part of array is ascending and only [10,1] is descending
        let middle = 10 ;
        so when array [middle] > array [middle + 1] is the Pivot Point
 */

/*
    Approach:

    1) Case 1 (Pivot Found):

        If arr[middle] > arr[middle + 1], middle is the pivot.
        Example: [8, 9, 10, 1, 2, 3, 4] → arr[middle] = 10 → Pivot found.

    2) Case 2 (Pivot Found in Previous Element):

        If arr[middle] < arr[middle - 1], then middle - 1 is the pivot.
        Example: [8, 9, 10, 1, 2, 3, 4] → arr[middle] = 1, but arr[middle - 1] = 10 → Pivot found at middle - 1.

    3) Case 3 (Move Right):

        If arr[start] ≤ arr[middle], then the left half is sorted, so the pivot is in the right half.
        Move start = middle + 1.

    4) Case 4 (Move Left):

        If arr[start] > arr[middle], then we are in the right half of the rotated array, so the pivot is in the left half.
        Move end = middle.
 */

public class b10_Pivot_Element {
    public static void main(String[] args) {
        int[] arr =   { 5, 6, 7, 1, 2, 3, 4};
        int[] arr_1 = { 5, 6, 7, 8, 2, 3, 4};
        int[] arr_2 = { 3, 4, 5, 0, 1, 2, 4};
        int[] arr_3 = { 10, 1, 2, 3, 4, 5, 7, 8, 9};
        int[] arr_4 = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int[] arr_5 = {1, 3, 5};
        int[] arr_6 = {1};

        System.out.println(Pivot_element(arr));
        System.out.println(Pivot_element(arr_1));
        System.out.println(Pivot_element(arr_2));
        System.out.println(Pivot_element(arr_3));
        System.out.println(Pivot_element(arr_4));
        System.out.println(Pivot_element(arr_5));
        System.out.println(Pivot_element(arr_6));
    }

    static int Pivot_element( int[] arr ){
        int start = 0 ;
        int end = arr.length-1;

        while ( start < end ){
            int middle = start + ( end - start ) / 2;

            // Case I:
                // if there are no greater element than middle means mid is a pivot
                // because  yeh inc hai toh isse age already small number hi available honge
            if( middle < end && arr[middle] > arr[middle + 1]){
                // there could be a situation in which mid is the last element
                // and if we do mid > mid+1 this will cause array out of bound That's why we create a case in this where mid > end
                return arr[ middle ];
            }

            // Case II:
                // same as case I
            else if ( middle > start && arr[middle] < arr[middle - 1]){
                return arr[ middle - 1];
            }

            // Case III:
                // If the element at start < element at greater than we move the start to mid + 1
                // because there would no greater between s and mid since it's a sorted array
                // and mid = mid + 1 because if mid would've been a pivot it would have already caught in Case I
            else if ( arr[start] <= arr[middle]){
                start = middle + 1;
            }

            // Case IV:
                // if the element at start > element means we are in another part of array after pivot point
                // so we move the end to end -1.
            else if ( arr[start] > arr[middle]){
                end = middle - 1;
            }
        }
            return -1;
    }
}
