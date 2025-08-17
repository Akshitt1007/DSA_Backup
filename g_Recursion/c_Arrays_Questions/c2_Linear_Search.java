package g_Recursion.c_Arrays_Questions;

public class c2_Linear_Search {
    public static void main(String[] args) {

        int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target1 = 8;

        int[] array2 = { 1, 2, 3, 4, 5, 8, 6, 7, 9, 10 };
        int target2 = 11;

        int index = find( array1, target1 );
        System.out.println( "Element present at index: " + index );

        int index2 = find( array2, target2 );
        System.out.println( "Element present at index: " + index2 );

    }

    static int find(int[] arr, int target) {
        return helper( arr , target , 0 );
    }

    static int helper( int[]arr , int target , int index ){

        if ( index > arr.length-1 ){
            return -1;
        }

        if ( arr[index] == target ){
            return index;
        }

        return helper( arr , target , index+1 );
    }
}
