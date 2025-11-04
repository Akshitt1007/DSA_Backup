package g_Recursion.c_Arrays_Questions;

class c3_Rotated_Binary_Search{
    public static void main(String[] args) {

        int[] array1 = { 6, 7, 8, 1, 2, 3, 4, 5 };
        int[] array2 = { 8, 1, 2, 3, 4, 5, 6, 7 };
        int[] array3 = { 2, 3, 4, 5, 6, 7, 8, 1 };
        int[] array4 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] array5 = { 1 };

        System.out.println(check_index(array1));
        System.out.println(check_index(array2));
        System.out.println(check_index(array3));
        System.out.println(check_index(array4));
        System.out.println(check_index(array5));
    }

    static int check_index( int[] arr ){
        return helper( arr , 0, arr.length-1 );
    }

    static int helper( int[]arr, int start, int end ){

        if ( arr[start] < arr[end] ){
            return -1;
        }
            // If the start is less than the end, the array is not rotated — it's fully sorted.
            // So no pivot found; hence returns -1.

        if (start == end) {
            return -1;
        }
            // Only one element

        int mid = ( start + end ) / 2;

        if ( arr[mid] > arr[mid+1] ) {
            return arr[mid];
        }
            // This checks if the current mid is the pivot.
            // If arr[mid] > arr[mid + 1], the current mid is where the rotation happened — return the pivot value.

        else if ( arr[mid] >= arr[start] ){
            return helper( arr, mid+1 , end );
        }
            // If arr[mid] > arr[start], it means the left part is sorted, so the pivot must be on the right.

        else {
            return helper( arr, start , mid );
        }
            // If arr[mid] < arr[start], the pivot must be on the left side.
            // case -> arr[mid] < arr[start]

    }
}