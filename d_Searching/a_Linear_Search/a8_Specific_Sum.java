package d_Searching.Linear_Search;

import java.util.Arrays;

public class a8_Specific_Sum {
    public static void main(String[] args) {
        int [] array = { 1,2,3,7,5};
        int target = 12;

        int[] answer = find_index(array, target);
        System.out.println(Arrays.toString(answer));
    }

    static int[] find_index( int [] array , int target){

        for ( int i = 0 ; i < array.length ; i++ ){
            int sum = 0;
            for ( int j = i ; j < array.length ; j++ ){
                sum = array[j] + sum ;
                if( sum == target ){
                    return new int[]{ i+1  , j+1 };
                }
            }
        }
        return new int[]{-1,-1};
    }
}