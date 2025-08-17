package c_Arrays;
/*
Problem 6: Count Frequency of Pairs with Difference k

You are tasked with counting how many pairs of integers in an array have a specific difference k.
•	Take an integer array arr[] and an integer k.
•	Output the count of unique pairs where the absolute difference between the pairs is k.
 */

public class x7_Count_Frequency_Pairs_with_Difference_k {
    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;

        int count = 0;

        for ( int i=0 ; i<arr.length ; i++ ){
            for( int j=0 ; j< arr.length ; j++ ){
                if ( arr[i]-arr[j] == k ){
                    count ++;
                }
            }
        }
        System.out.println( count );
    }
}
