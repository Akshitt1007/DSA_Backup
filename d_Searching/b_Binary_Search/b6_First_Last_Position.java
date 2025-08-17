package d_Searching.Binary_Search;

import java.util.Arrays;

public class b6_First_Last_Position {

    public static void main(String[] args) {

        int[] array = {5,7,7,8,8,10};
        int target = 8;

        int[] array_2 = {};
        int target_2 = 10;

        int[] array_3 = { 5,7,7,8,8,10 };
        int target_3 = 9 ;

        int[] answer = searchRange( array , target );
        System.out.println( Arrays.toString (answer));

        int[] answer_2 = searchRange( array_2 , target_2 );
        System.out.println( Arrays.toString (answer_2));

        int[] answer_3 = searchRange( array_3 , target_3 );
        System.out.println( Arrays.toString ( answer_3 ));
    }

    static int[] searchRange(int[] nums, int target) {

        if( nums.length == 0){
            return new int[]{-1,-1};
        }

        int start = 0;
        int end = nums.length-1;

        int first = -1;

        while( start <= end){
            int middle = start + ( end - start ) / 2 ;

            if ( target < nums[middle] ){
                end = middle - 1;
            }

            else if ( target > nums[middle] ){
                start = middle + 1;
            }

            else{
                first = middle;
                end = middle-1;
            }
        }

        start = 0;
        end = nums.length-1 ;

        int last = -1;

        while( start <= end){
            int middle = start + ( end - start ) / 2 ;

            if ( target < nums[middle] ){
                end = middle - 1;
            }
            else if ( target > nums[middle] ){
                start = middle + 1;
            }
            else{
                last = middle ;
                start = middle + 1;
            }
        }

        return new int[]{ first , last };

    }
}
