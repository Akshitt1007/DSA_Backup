package e_Sorting.c_Cycle_sort.Questions;

import java.util.Arrays;

public class a5_miss_match {
    public static void main(String[] args) {

        int[] array_0 = { 1, 2, 2, 4 };
        int[] array_1 = { 1, 1 };
        int[] array_2 = { 2, 2 };

        System.out.println( Arrays.toString( misMatch( array_0 ) ) );
        System.out.println( Arrays.toString( misMatch( array_1 ) ) );
        System.out.println( Arrays.toString( misMatch( array_2 ) ) );
    }

    static int[] misMatch ( int[] nums ){

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

                return new int[] { nums[j] , j+1 };

            }
        }
        return new int[] { -1 , -1 };
    }
}
