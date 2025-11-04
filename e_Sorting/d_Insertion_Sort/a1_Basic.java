package e_Sorting.d_Insertion_Sort;

import java.util.Arrays;

public class a1_Basic {

    public static void main(String[] args) {

        int[] array = { 5, 3, 4, 1, 2 };
        int[] array_2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        System.out.println(Arrays.toString( insertion_sort ( array )) );

        System.out.println(Arrays.toString( insertion_sort_better ( array_2 )) );
    }

    static int[] insertion_sort_better ( int[] arr ){

        for ( int i = 0 ; i < arr.length - 1 ; i++ ){

            for ( int j = i+1 ; j > 0 ; j-- ){

                if ( arr[j] < arr[j-1] ){

                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                }

                else{
                    break;
                }
            }
        }
        return arr;
    }

    static int[] insertion_sort ( int[] arr ){

        for ( int i = 0 ; i < arr.length - 1 ; i++ ){

            for ( int j = i+1 ; j < arr.length ; j++ ){

                while ( j > 0 && arr[j] < arr[j-1] ) {

                    if ( arr[j] < arr[j-1] ){

                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;

                        j--;
                    }

                    else{
                        break;
                    }
                }
            }
        }
        return arr;
    }
}
