package c_Arrays;

import java.util.Arrays;

// Leetcode 26

public class x1_Sort_Array_with_non_duplicate {
    public static void main(String[] args) {

        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        System.out.println( Arrays.toString( Sort_Array_with_non_duplicate(arr) ));
    }

    static int[] Sort_Array_with_non_duplicate (int[] nums) {

        if ( nums.length == 0 ){
            return new int[]{-1,-1};
        }

        int count = 1;

        for ( int i = 1 ; i< nums.length; i++){
            if( nums[i] != nums[i-1]){
                nums[count]= nums[i];
                count++;
            }
        }
        return nums;
    }
}
