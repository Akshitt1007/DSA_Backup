package c_Arrays;
/*
Largest Sum of Non-Adjacent Elements

Given an integer array nums, find the maximum sum of non-adjacent elements.
•	Accept an integer array as input.
•	Calculate the maximum sum of non-adjacent elements.
•	Output the maximum sum and the elements contributing to this sum.
 */
public class x8_Largest_Sum_of_NonAdjacent_Elements {
    public static void main(String[] args) {

//        int[] nums = {3, 2, 5, 10, 7};
//        int[] nums = {5, 5, 10, 100, 10, 5};
        int[] nums = {4, -1, 2, 1, -5, 4};

        int max = 0;

        for ( int i=0 ; i<nums.length ; i++ ){
            for ( int j=i+2 ; j< nums.length ; j++ ){
                for ( int k= j+2 ; k< nums.length ; k++ ){
                    int temp = nums[i] + nums[j] + nums[k] ;

                    if( temp > max ){
                        max = temp;
                    }
                }
            }
        }

        System.out.println( max );
    }
}
