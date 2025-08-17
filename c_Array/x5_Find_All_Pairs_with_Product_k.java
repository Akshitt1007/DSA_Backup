package c_Arrays;

/*
Problem 2: Find All Pairs with Product k

Write a Java program that finds all unique pairs of integers in an array whose product equals a target value k.
•	Take an integer array nums[] and an integer k as input.
•	Print all unique pairs whose product equals k.
•	If no such pairs exist, output an appropriate message.
 */

public class x5_Find_All_Pairs_with_Product_k {
    public static void main(String[] args) {

        int[] array = {2, 4, 1, 6, 3};
        int k = 6;
//        int[] array = {5,6,11,3, 10};
//        int k = 30;

        for ( int i=0 ; i< array.length ; i++ ){
            for ( int j=i+1 ; j< array.length; j++){
                if( (array[i] * array[j]) == k ){
                    System.out.println( "(" + array[i] +","+array[j]+")");
                }
            }
        }

    }
}
