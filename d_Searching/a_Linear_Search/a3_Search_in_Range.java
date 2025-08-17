package d_Searching.Linear_Search;

import java.util.Arrays;
import java.util.Scanner;

public class a3_Search_in_Range {
    public static void main(String [] args){
        Scanner s1 = new Scanner(System.in);

        int[] array = { 1,2,43,-1,3,6,10};

        System.out.println("Enter the start index: ");
        int start = s1.nextInt();

        System.out.println("Enter the end index: ");
        int end = s1.nextInt();

        System.out.println("Enter the Target: ");
        int target = s1.nextInt();

        int index = find_in_range(array , start , end , target );
        if( index == -1){
            System.out.println("Not found");
        }
        else{
            System.out.println("Target at " + index + " index.");
        }

    }

    static int find_in_range(int[] range , int start , int end , int target){

        if( range.length == 0 ){
            return -1;
        }

        for( int i = start ; i <= end ; i++ ){
            if ( range[i] == target ){
                return i ;
            }
        }
        return -1;
    }
}
