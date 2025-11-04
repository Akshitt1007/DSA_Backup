package d_Searching.b_Binary_Search;

public class b14_Split_Array_Largest_Sum {
    public static void main(String[] args) {

        int[] arr = { 7, 2, 5, 10, 8 };
        int times = 2;

        System.out.println("Smallest sum of array is: " + Split_Array_Largest_Sum( arr , times ));
    }


    static int sum( int[] arr, int start , int end , int times ){

        int sum = 0;
        int max = 0;

        while ( start < end ){
            int mid = start + ( end - start ) / 2;
            int i=0;
            while( sum <= mid){
                sum = arr[i] + sum;
                i++;
            }
        }
        return end ;
    }


    static int Split_Array_Largest_Sum( int[]arr , int times ){
        int max = 0;
        for ( int i = 0 ; i< arr.length-1 ; i++){
            if (arr[i]> arr[i+1]){
                    max = arr[i];
            }
        }
        int start = max ;

        int sum = 0 ;
        for ( int i = 0 ; i < arr.length ; i++ ){
            sum = sum + arr[i];
        }
        int end = sum ;

        return sum( arr, start , end , times);
    }
}
