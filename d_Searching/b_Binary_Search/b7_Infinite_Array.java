package d_Searching.Binary_Search;

// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

public class b7_Infinite_Array {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 30, 40, 50 , 60 , 70 , 80, 90, 100 ,170 , 223 , 555, 1391};
        int target = 40 ;

        int answer =  finding_range( array , target );

        if( answer == -1 ){
            System.out.println("Not found in infinite array");
        }
        else{
            System.out.println( target + " is present at " + answer + " index of infinite array ");
        }
    }

    static int finding_range ( int [] array , int target ){

        // creating a basic short search space and increasing this search space with time
        int start = 0 ;
        int end = 1;

        // if the target is greater than the array end then we have to increase our search space
        while( target > array[end] ){


            // setting the new start after previous end
            int new_start = end + 1 ;

            // double the box value
            // end = previous_end + size_of_box * 2
            end = end + ( end - start + 1 ) * 2;

            start = new_start;
            /*
                start = end;
                end *= 2;
            */
        }

        // when the target will no longer be greater than end value
        // means it will lie in the search space which can we further searched viva normal binary search method
        return infinite_array_find_index(array , target , start , end);
    }


    static int infinite_array_find_index( int[] array , int target , int start , int end ){

        while ( start <= end ){

            int middle = start + ( end - start ) / 2;

            if ( target > array[middle] ){
                start = middle + 1;
            }
            else if ( target < array[middle] ){
                end = middle - 1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }
}
