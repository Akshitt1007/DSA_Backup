package e_Sorting.c_Cycle_sort.Questions;

// https://leetcode.com/problems/missing-number/

// Amazon Question

public class a1_Missing_number {

    public static void main(String[] args) {

        int[] array_0 = {4, 0, 2, 1};
        int[] array_1 = {0, 1};
        int[] array_2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] array_3 = {};  // Edge Case: Empty array
        int[] array_4 = {0}; // Edge Case: Single-element array

        System.out.println(missing_number(array_0));  // Output: 3
        System.out.println(missing_number(array_1));  // Output: 2
        System.out.println(missing_number(array_2));  // Output: 8
        System.out.println(missing_number(array_3));  // Output: 0
        System.out.println(missing_number(array_4));  // Output: 1

    }

    static int missing_number ( int[] nums ){

        int i = 0;

        while ( i < nums.length ){

            int index = nums[i];
                // Here we will not do arr[i]-1 because our array is starting from 0 value only
                // so all the element would be automatically at the correct index

            if ( nums[i] < nums.length && nums[i] != nums[index] ){
                    // by nums[i] < nums.length
                        // we can check whether the element we are on should not be greater than the size then array
                        // if we have same element of that of size of array this will cause out of bound error
                            // since there would also be a missing number that's why we are ignoring it making it coming in last
                            // and there is no element which is the size of array then that would be the missing number
                            // which will be caught in the 67 line of this code

                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                    // same swapping of numbers

            }
            else{
                i++;
                    // if the element is same at the index
                    // or the element is the size of array
                    // then it will get incremented
            }
        }

            // by the time our code would reach here
            // our array must have been sorted

            // 9, 6, 4, 2, 3, 5, 7, 0, 1

            // array = 0, 1, 2, 3, 4, 5, 6, 7, 9
            // index = 0  1  2  3  4  5  6  7  8
                // here at index 8 , element 9 is present which is not correct which can be return by the following loop


        for ( int index = 0 ; index < nums.length ; index++ ){
            if ( nums[index] != index ){
                return index ;
            }
        }

            // but if the array is :
                                // array = 3, 2, 1, 0
                                // index = 0  1  2  3
                                // missing element is 4 which is the size of array then we would simply return the size of array
        return nums.length;
    }
}
