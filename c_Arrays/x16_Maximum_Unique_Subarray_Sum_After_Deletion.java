package c_Arrays;

//3487. Maximum Unique Subarray Sum After Deletion
//https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/?envType=daily-question&envId=2025-07-25

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class x16_Maximum_Unique_Subarray_Sum_After_Deletion {
    public static void main(String[] args) {

        int[] array = {-17,-15};
        int[] array2 = {1,1,0,1,1};
//        int[] array3 = {-59, 77, 81, -32, -58, -73, 22, -28, 48, -43, -34, -43, -45, 3, 78, 78, 6, -74, -91, -84, 6, -47, 80, 0, -88, 4, -44, 8, 42, 99, 72, -96, -13, -32, 12, 91, 59, -26, 18, -11, 60, 85, -67, 14, -85, 20, -34, -95, -91, 62, 75, -87, 14, -81, 30, 5, -31, -43, 68, 74, 71, 9, 36, -72, 38, -55, 38, 1, -13, 31, -62, 37, -44, -38, 28, 75, -54, -43, 22, -20, -23, 36, -30, -23, 27, -24, 2, 50, -14, -2, -78, 81, 31, 32, -70, -20, 11, 39, 58, 23};

        System.out.println( maxSum(array) );
        System.out.println( max_sum_II(array2) );
    }

    public static int maxSum(int[] nums) {

        if (nums.length == 1 ){
            return nums[0];
        }

        HashSet<Integer> ntr = new HashSet<>();

        for( int i=0 ; i<nums.length ; i++ ){
            ntr.add( nums[i] );
        }

        ArrayList<Integer> list = new ArrayList<>(ntr);

        int max_sum = 0;
        boolean check = false;


        for (int j = 0; j < list.size(); j++) {
            if ( list.get(j) > 0 ){
                max_sum += list.get(j);
                check = true;
            }
        }

        int max = Integer.MIN_VALUE;
        if( check == false ){
            for( int i=0 ; i<nums.length ; i++ ){
                if ( max < nums[i]){
                    max = nums[i];
                }
            }
            max_sum = max;
        }
        return max_sum;
    }

    public static int max_sum_II( int[] nums ){
        Arrays.sort( nums );

        int x = nums[ nums.length-1 ];
        int max_sum = x;

        for( int i = nums.length-2 ; i >= 0 ; i-- ){

            if( nums[i] <= 0 ){
                return max_sum;
            }
            else if ( nums[i] != x ){
                max_sum = max_sum + nums[i];
            }

            x = nums[i];
        }

        return max_sum;
    }
}
