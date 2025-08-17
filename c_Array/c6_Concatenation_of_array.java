package c_Arrays;

import java.util.Arrays;

public class c6_Concatenation_of_array {
    public static void main(String[] args) {
        
        int[] array_1 = { 1, 2, 3};
        int[] array_2 = { 4, 5, 6};
        int[] array_3 = { 7, 8, 9};

        System.out.println(Arrays.toString( Joining_array ( array_1 , array_2 , array_3)));
    }

    static int[] Joining_array( int[] arr , int[] arr2 , int[] arr3){

        int[] new_arr = new int [ arr.length + arr2.length + arr3.length ];

        for ( int i = 0 ; i < arr.length ; i++ ){

            new_arr[i] = arr[i];
        }

        for ( int j = 0 ; j < arr2.length ; j++ ){

            new_arr[arr.length + j ] = arr2[j];
        }

        for ( int k = 0 ; k < arr3.length ; k++ ){

            new_arr[arr.length + arr2.length + k] = arr3[k];
        }

        return new_arr;
    }
}

