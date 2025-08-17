package g_Recursion;

public class a4_BinarySearch_Thr_Recursion {
    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int target = 7;

        int start = 0;
        int end = array.length-1;

        int index = binary_search( array, target, start, end );

        System.out.println("Index of the target element is: " + index );
    }

    static int binary_search( int[]arr, int target , int start , int end ){

        if ( start > end ){
            return -1;
        }

        int mid = ( start + end ) / 2;

        if ( target > arr[mid] ){
            return binary_search( arr, target , mid+1 , end);
        }
        else if ( target < arr[mid] ){
            return binary_search( arr, target , start , mid-1);
        }
        else{
            return mid;
        }

    }
}
