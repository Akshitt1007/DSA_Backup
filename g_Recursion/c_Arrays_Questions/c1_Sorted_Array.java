package g_Recursion.c_Arrays_Questions;

import java.util.Arrays;

public class c1_Sorted_Array {
    public static void main(String[] args) {

        int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] array2 = { 1, 2, 3, 4, 5, 8, 6, 7, 9, 10 };

        int[] array3 = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 9 };

        int[] array4 = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] array5 = { 1 };

        int[] array6 = { 1, 1, 2, 2, 3, 3 };

        System.out.println(Arrays.toString(array1));
        check(array1);
        System.out.println();

        System.out.println(Arrays.toString(array2));
        check(array2);
        System.out.println();

        System.out.println(Arrays.toString(array3));
        check(array3);
        System.out.println();

        System.out.println(Arrays.toString(array4));
        check(array4);
        System.out.println();

        System.out.println(Arrays.toString(array5));
        check(array5);
        System.out.println();

        System.out.println(Arrays.toString(array6));
        check(array6);
        System.out.println();
    }

    static void check(int[] arr) {

        if ( isSorted(arr, 0, arr.length-1 )) {
            System.out.println("Yes sorted!!");
        } else {
            System.out.println("Not sorted!!");
        }

    }

    static boolean isSorted(int[] arr, int index, int end) {

        if ( index >= end ) {
            return true;
        }

        if ( arr[index] > arr[index + 1 ]) {
            return false;
        }

//        if (arr[index] <= arr[index + 1]) {
//            return isSorted(arr,  index+ 1, end);
//        }

        return isSorted(arr,  index+ 1, end);
    }

    /*
    Simpler and clean version:

    static boolean Sorted( int[]arr, int index ){
        if ( index == arr.length-1 ){
            return true;
        }
        return arr[index] <= arr[index+1] && Sorted( arr, index+1 );
    }
     */
}
