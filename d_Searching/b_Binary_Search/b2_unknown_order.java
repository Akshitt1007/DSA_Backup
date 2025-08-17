package d_Searching.Binary_Search;

import java.util.Scanner;

        /*
            When we don't know the order of the array/-

            Identify the first (start) and last (end) elements of the array.

            a) start refers to the first element of the array (arr[0]).
            b) end refers to the last element of the array (arr[n-1]).

            Compare the values of start and end:

            1) If start > end, the array is sorted in descending order.
            2) If start < end, the array is sorted in ascending order.
         */

public class b2_unknown_order {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter target element: ");
        int target = s1.nextInt();

        int index = 0;

//        int [] array = {10,9,8,7,6,5,4,3,2,1};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /*
        int start = 0;
        int end = array.length-1;

        if( array[start] > array[end] ){
            index = find_decreasing(array, target );
            System.out.println("Element at: " + index );
        }
        else{
            index = find_increasing(array , target);
            System.out.println("Element at: " + index );
        }
    */

        index = find_index(array, target);
        System.out.println("Your Target is at index" + index);
    }

    static int find_index(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        boolean check = false;
        if (array[start] > array[end]) {     // This to check whether our array is ascending or descending order
            check = true;                   // If the start > end means decreasing order
        }                                   // Else increasing order

        while (start <= end) {

            int middle = (start + end) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (check == false) {                 // This block is for decreasing order
                if (target > array[middle]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {                               // This block is for increasing order
                if (target < array[middle]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }
}

/*
    static int find_decreasing(int [] array , int target ){
        int start = 0;
        int end = array.length-1;

        while( start <= end ){

            int middle = (start+end)/2;

            if(array[middle] == target){
                return middle;
            }
            else if( target < array[middle] ){
                start = middle + 1;
            }
            else{
                end = middle - 1;
            }
        }
        return -1;
    }
    static int find_increasing(int [] array , int target ){
        int start = 0;
        int end = array.length-1;

        while( start <= end ){

            int middle = (start+end)/2;

            if(array[middle] == target){
                return middle;
            }
            else if( target > array[middle] ){
                start = middle + 1;
            }
            else{
                end = middle - 1;
            }
        }
        return -1;
    }
*/


