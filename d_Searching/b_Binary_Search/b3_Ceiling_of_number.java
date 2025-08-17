package d_Searching.Binary_Search;
/*
    What is ceiling of a number ?

    It is the smallest number in the array that is greater or equal to target element
    (we have to find the next number to target element).

    if given array = { 1,2,3,5,10,12,20,22};

    and we have to find the ceiling of target element 8
    then 10 is the ceiling number of target 8

    and we have to find the ceiling of target element 10
    then 10 is the ceiling number of target 10
 */

import java.util.Scanner;

public class b3_Ceiling_of_number {

    public static void main(String[] args) {
        Scanner s1 = new Scanner (System.in);

        int [] array = { 1 , 2 , 3 , 5 , 10 , 12 , 20 , 22 };

        System.out.println("Ceiling of 8: " + find_Ceiling(array, 4));  // Output: 5
        System.out.println("Ceiling of 10: " + find_Ceiling(array, 10)); // Output: 10
        System.out.println("Ceiling of 21: " + find_Ceiling(array, 21)); // Output: 22
        System.out.println("Ceiling of 23: " + find_Ceiling(array, 23)); // Output: Integer.MAX_VALUE (No ceiling exists)
    }

    static int find_Ceiling( int[] arr , int target ){
        int start = 0;
        int end = arr.length-1;

        if( target > arr[end]){
            return Integer.MAX_VALUE;
        }

        while( start <= end ){
            int middle = ( start + end ) / 2 ;

            if ( target < arr[middle]){
                end = middle - 1;
            }
            else if ( target > arr[middle] ){
                start = middle + 1;
            }
            else{
                return target ;
            }

        }
        return arr[start];
    }
}
