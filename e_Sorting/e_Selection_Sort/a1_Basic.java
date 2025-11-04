package e_Sorting.e_Selection_Sort;

import java.util.Arrays;

public class a1_Basic {
    public static void main(String[] args) {

        int[] array_1 = { 3, 1, 5, 2, 4 };
        int[] array_2 = { 5, 4, 3, 2, 1 };
        int[] array_3 = { 10 , 8, 0 , -29 , -100 };

        System.out.println( Arrays.toString( selection_sort_by_max_value (array_1) ) );
        System.out.println( Arrays.toString( selection_sort_by_min_value (array_2) ) );
        System.out.println( Arrays.toString( selection_sort_by_min_value (array_3) ) );

    }

    static int[] selection_sort_by_min_value ( int[] arr ){

        for ( int i = 0 ; i < arr.length-1 ; i++ ){

            int min_Index = i;

            for ( int j = i+1 ; j < arr.length-i ; j++ ){

                if( arr[ min_Index ] > arr[j] ){

                    min_Index = j;

                }
            }

            if ( min_Index != i ){

                int temp = arr[ i ];
                arr[ i ] = arr[ min_Index ];
                arr[ min_Index ] = temp;

            }
        }
        return arr;
    }

    static int[] selection_sort_by_max_value ( int[] arr ){

        for ( int i = 0 ; i < arr.length-1 ; i++ ){

            int max_Index = 0;

            for ( int j = 0 ; j < arr.length-i ; j++ ){

                if( arr[ max_Index] < arr[j] ){

                    max_Index = j;

                }
            }

            swap_element( arr , max_Index ,i);
            /*
                int temp = arr[ arr.length-1-i ];
                arr[ arr.length-1-i ] = arr[ max_Index ];
                arr[ max_Index ] = temp;
            */
        }
        return arr;
    }

    static void swap_element ( int[]arr , int max_index , int i){

        int temp = arr[ arr.length-1-i];            // Putting the last value of arr in temp
        arr[ arr.length-1-i ] = arr[max_index];     // putting the max value at the last position of arr
        arr[ max_index ] = temp;                    // Putting the last value of arr in the position of max element index

    }
}
