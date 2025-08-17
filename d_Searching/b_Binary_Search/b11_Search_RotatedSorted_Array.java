package d_Searching.Binary_Search;

public class b11_Search_RotatedSorted_Array {
    public static void main(String[] args) {
//        int[] array = { 6, 7, 8, 9, 1, 2, 3, 4, 5 };
        int target = 3;
        int[] array = { 3,1};

        System.out.println( find_index( array , target) );
    }

    static int find_index( int[] arr , int target ){

        int pivot = find_pivot( arr );

        if( pivot == -1 ){
            return binary_search ( arr , target , 0 , arr.length-1 );
        }

        if ( arr[0] <= target ){
            return binary_search ( arr , target , 0 , pivot );
        }
        else{
            return binary_search ( arr , target , pivot + 1 , arr.length-1 );
        }

    }

    static int binary_search( int[] arr , int target , int start , int end ){

        while (start <= end ){

            int middle = start + ( end - start ) / 2;

            if( arr[middle] > target ){
                end = middle - 1;
            }
            else if ( arr[middle] < target ){
                start = middle + 1;
            }
            else{
                return middle;
            }
        }
        return - 1;
    }

    static int find_pivot ( int[] arr ) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int middle = start + (end - start) / 2;

            // Check if middle element is greater than the next element (pivot point)
            if (middle < end && arr[middle] > arr[middle + 1]) {
                return middle;  // Pivot found
            }

            // Check if middle element is smaller than the previous element
            else if (middle > start && arr[middle] < arr[middle - 1]) {
                return middle - 1;  // Pivot found
            }

            // If the left side is sorted, move to the right side
            else if (arr[start] <= arr[middle]) {
                start = middle + 1;
            }

            // If the right side is sorted, move to the left side
            else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
