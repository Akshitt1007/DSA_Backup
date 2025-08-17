package e_Sorting.c_Cycle_sort;

import java.util.Arrays;

/*

    when number in array is given from 1 to N
        then always use cyclic sort

 */

public class a1_Basic {
    public static void main(String[] args) {

        int[] array_1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        int[] array_2 = { 1, 3, 4, 2, 2 };

        cyclic_sort( array_1 );
        cyclic_sort( array_2 );

        System.out.println(Arrays.toString( array_1 ));
        System.out.println(Arrays.toString( array_2 ));

    }
    static void cyclic_sort( int[] arr ){

        int i = 0;

        while ( i < arr.length ){

            int index = arr[i] - 1;

            if ( arr[i] != arr[index] ){

                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

            }
            else {

                i++;

            }
        }
    }
    /*
    static void cyclic_sort( int[] arr ){

        for ( int i = 0 ; i < arr.length ; ){
            int value = arr[i] - 1;
            if ( value == i ){
                i++;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[value];
                arr[value] = temp;
            }
        }
    }
     */
}
