package e_Sorting.c_Cycle_sort.Questions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

public class a2_Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {

        int[] array_0 = { 4, 3, 2, 7, 8, 2, 3, 1};
//        int[] array_0 = { 1, 1 };

        List<Integer> sum_between_given_index = findDisappearedNumbers(array_0);
        System.out.println( sum_between_given_index );

    }

    static List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> list = new ArrayList<Integer>(5);

        int i = 0;

        while ( i < nums.length ){

            int index = nums[i] - 1 ;

            if (  nums[i] != nums[index] ){

                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;

            }
            else{
                i++;
            }
        }

        for ( int index = 0 ; index < nums.length ; index++ ){

            if ( nums[index]-1 !=  index ){

                list.add( index + 1 );

            }
        }

        return list;
    }
}
