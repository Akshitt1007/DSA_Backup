package c_Arrays;
/*
Problem 6 (Again): Maximum Sum of K Consecutive Elements

Given an integer array nums and an integer k, find the maximum sum of any contiguous subarray of size k.
•	Accept an integer array and an integer k as input.
•	Calculate and return the maximum sum of any contiguous subarray of size k.
•	Handle edge cases when k is larger than the size of the array.
 */
public class x11_Maximum_Sum_of_K_Consecutive_Elements {
    public static void main(String[] args) {
//        int[] nums = {2, 1, 5, 1, 3, 2};
//        int k = 3;
        int[] nums = {-2, -3, -1, -4};
        int k = 2;
//        int[] nums = {1, 2, 3};
//        int k = 5;


        // Edge case: k is larger than array size
        if (k > nums.length) {
            System.out.println("Window size k is larger than array size!");
            return;
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += nums[j];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println("Maximum sum of " + k + " consecutive elements is: " + maxSum);
    }
}
