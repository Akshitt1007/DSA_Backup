package m_Stack_n_Queues;

//https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.Stack;

public class x3_Largest_Rectangle_in_Histograph {
    public static void main(String[] args) {

        int[] graph = { 1, 1, 1, 1 };

        int largestArea = largestRectangleArea( graph );
        System.out.println( largestArea );
    }

    // Optimized Solution
    public static int largestRectangleArea_Optimized(int[] height) {

        Stack<Integer> stack = new Stack<>();

        int max = 0;

        stack.push( 0 );

        for ( int i=1 ; i<height.length ; i++ ){

            while ( !stack.isEmpty() && height[i] < height[ stack.peek()] ){
                max = getMax( height, stack , max , i );
            }
            stack.push( i );
        }

        int i = height.length;
        while( !stack.isEmpty() ){
            max = getMax( height, stack , max , i );
        }

        return max;
    }

    public static int getMax( int[] arr, Stack<Integer> stack , int max , int i ){

        int area ;
        int pooped = stack.pop();

        if ( stack.isEmpty() ){
            area = arr[pooped] * i;
        }
        else{
            area = arr[pooped] * ( i - 1 - stack.peek() );
        }

        return Math.max( max , area );
    }


    // Brute Force Approach
    public static int largestRectangleArea(int[] height) {

        Stack<Integer> TotalArea = new Stack<>();

        for( int i=0 ; i<height.length ; i++){
            int current_block = height[i];
            int area = 0;
            int width = 1;

            for( int j=i+1 ; j< height.length-1; j++){
                if( height[j] >= current_block){
                    width++;
                }
                else{
                    break;
                }
            }
            for( int k=i-1 ; k>= 0;  k-- ){
                if( height[k] >= current_block){
                    width++;
                }
                else{
                    break;
                }
            }

            area = width * current_block;
            TotalArea.push( area );
        }

        int max = 0;
        for (int val : TotalArea) {
            if (val > max) {
                max = val;
            }
        }

        return max;
    }
}
