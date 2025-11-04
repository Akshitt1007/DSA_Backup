package p_HashSet_n_HashMap;

import java.util.HashSet;

//1695. Maximum Erasure Value
//https://leetcode.com/problems/maximum-erasure-value/description/?envType=daily-question&envId=2025-07-22

public class x1_Maximum_Erasure_Sum {
    public static void main(String[] args) {

        int[] arr = {5,2,1,2,5,2,1,2,5};
//        Output: 8
//        Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

        System.out.println( maximumUniqueSubarray(arr) );
    }

    public static int maximumUniqueSubarray(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;
        int max_sum = 0;
        int x = 0;

        for( int i=0 ; i<nums.length ; i++ ){

            while (  set.contains( nums[i] )){
                set.remove( nums[x] );
                sum = sum - nums[x];
                x++;
            }

            set.add( nums[i] );
            sum = sum + nums[i];

            if ( max_sum < sum ){
                max_sum = sum;
            }
        }

        return max_sum;

    }
}
