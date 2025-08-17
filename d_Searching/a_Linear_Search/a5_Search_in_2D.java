package d_Searching.Linear_Search;

import java.util.Scanner;
import java.util.Arrays;

public class a5_Search_in_2D {
    public static void main( String[] args ){
        Scanner s1 = new Scanner (System.in);

        int[][] array = new int[3][3];

        System.out.println("Enter the 2D array: ");
        for(int i=0 ; i < array.length ; i++){
            for( int j=0 ; j < array[i].length ; j++){
                array[i][j] = s1.nextInt();
            }
        }
        System.out.println("Enter the target element: ");
        int target = s1.nextInt();

        int [] index = in_2D( array , target );

        System.out.println("Target element is at: " + Arrays.toString(index));

        System.out.println("Maximum number is: " + max(array));

    }

    static int [] in_2D( int[][] array , int target){

        for(int i=0 ; i < array.length ; i++){
            for( int j=0 ; j < array[i].length ; j++){
               if( array[i][j] == target){
                   return new int[]{i,j};
               }
            }
        }
        return new int[]{-1,-1};
    }

    static int max( int[][] array ){

        int max = Integer.MAX_VALUE;

        for(int i=0 ; i < array.length ; i++){
            for( int j=0 ; j < array[i].length ; j++){
                if( array[i][j] > max ){
                    max = array[i][j] ;
                }
            }
        }
        return max;
    }
}
