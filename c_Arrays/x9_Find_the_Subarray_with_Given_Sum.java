package c_Arrays;

/*
Problem 8: Find the Subarray with Given Sum

Given an integer array nums and an integer target, find the contiguous subarray that sums up to target.
•	Accept an integer array and an integer target as input.
•	Search for a contiguous subarray whose sum equals target.
•	Return the starting and ending indices of the subarray if found; otherwise, indicate no such subarray exists.
 */
public class x9_Find_the_Subarray_with_Given_Sum {
    public static void main(String[] args) {

        int[] nums = {1, 4, 20, 3, 10, 5};
        int target = 33;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if ( sum == target ) {
                System.out.println("Subarray found from index " + i + " to " + i);
                found = true;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];

                if (sum == target) {
                    System.out.println("Subarray found from index " + i + " to " + j);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("No subarray with sum " + target + " found.");
        }

    }
}
