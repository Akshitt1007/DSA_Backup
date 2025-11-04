package c_Arrays;

import java.util.ArrayList;
import java.util.List;

/*
Problem 1: Find All Pairs with Sum Closest to k

You are given an integer array arr[] and an integer k.
•	Print all unique pairs whose sum is closest to k.
•	If no such pairs exist, output an appropriate message.
 */
public class x10_All_Pairs_with_Sum_Closest_k {
    public static void main(String[] args) {

        List<String> result = new ArrayList<>();

//        int[] arr = {1, 3, 4, 7, 10};
//        int k = 15;
        int[] arr = {1, 3, 6, 8, 10};
        int k = 14;

//        int a =0;
//        int b = 0;

        int diff = Integer.MAX_VALUE;

        for ( int i=0; i<arr.length ; i++ ){
            for ( int j=i+1 ; j<arr.length ; j++ ){
                int sum = arr[i]+ arr[j];

                int tempDiff = 0;
                if( sum < k ){
                    tempDiff = k - sum;
                }else{
                    tempDiff = sum - k;
                }
//                if ( temp < diff ){
//                    diff = temp;
//                    a = arr[i];
//                    b = arr[j];
//                }

                if (tempDiff < diff) {
                    diff = tempDiff;
                    result.clear(); // start fresh
                    result.add(arr[i] + "," + arr[j]);
                } else if (tempDiff == diff) {
                    result.add(arr[i] + "," + arr[j]); // same closeness
                }

            }
        }
//        System.out.println( a + " " + b );
        if (result.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            System.out.println("Pairs with sum closest to " + k + ":");
            for (String pair : result) {
                System.out.println("(" + pair + ")");
            }
        }
    }
}
