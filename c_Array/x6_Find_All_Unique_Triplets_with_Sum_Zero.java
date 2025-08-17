package c_Arrays;

/*
Problem 5: Find All Unique Triplets with Sum Zero

Given an integer array nums[], write a Java program to find all unique triplets that sum to zero.
•	Take an integer array nums[] as input.
•	Print all unique triplets that sum to zero.
•	If no such triplet exists, output an appropriate message.
 */

public class x6_Find_All_Unique_Triplets_with_Sum_Zero {
    public static void main(String[] args) {

        int[] arr = {1, -1, 2, -2, 0};

        for( int i=0 ; i<arr.length ; i++ ){
            for( int j=i+1 ; j<arr.length ; j++ ){
                for ( int k=i+2 ; k< arr.length ; k++ ){
                    if ( arr[i]+arr[j]+arr[k] == 0){
                        System.out.println( arr[i] + "," + arr[j] + "," + arr[k] );
                    }
                }
            }
        }

    }
}
