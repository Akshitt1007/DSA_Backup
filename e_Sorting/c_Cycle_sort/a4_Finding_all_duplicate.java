package e_Sorting.c_Cycle_sort.Questions;

import java.util.ArrayList;
import java.util.List;

public class a4_Finding_all_duplicate {
    public static void main(String[] args) {

        int[] array_0 = {4,3,2,7,8,2,3,1};
        int[] array_1 = {1,1,2};
        int[] array_2 = {1};


        System.out.println( findDuplicates( array_0 ) );
        System.out.println( findDuplicates( array_1 ) );
        System.out.println( findDuplicates( array_2 ) );

    }

    static List<Integer> findDuplicates(int[] nums) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        int i = 0 ;

        while ( i < nums.length ){

            int index = nums[i] - 1;

            if ( nums[i] != nums[index] ){

                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;

            }

            else{

                i++;

            }
        }

        for ( int j = 0 ; j < nums.length ; j++ ){

            if ( nums[j]-1 != j ){

                list.add(nums[j]);
            }
        }
        return list;
    }
}
