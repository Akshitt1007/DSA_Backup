package c_Arrays;

import java.util.Arrays;

//169. Majority Element
//https://leetcode.com/problems/majority-element/description/

public class x18_Majority_Elements {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int count = 1;
        int maxCount = 1;
        int majority = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                majority = nums[i];
            }
        }

        return majority;
    }
}
