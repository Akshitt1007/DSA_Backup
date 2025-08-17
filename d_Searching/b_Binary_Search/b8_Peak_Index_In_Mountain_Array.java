package d_Searching.Binary_Search;

/*
    You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
    Return the index of the peak element.
    Your task is to solve it in O(log(n)) time complexity.
    Example 1:
    Input: arr = [0,1,2,3,4,3,2,1]
    Output: 4

    Example 2:
    Input: arr = [0,2,1,0]
    Output: 1

    Example 3:
    Input: arr = [0,10,5,2]
    Output: 1
*/

public class b8_Peak_Index_In_Mountain_Array {
    public static void main(String[] args) {
        int[] array = {  1, 2, 3, 5, 6, 4, 3, 2};

        System.out.println( "Peak index is: " + peak_index( array ) );
    }

    static int peak_index( int [] array ){

        int start = 0;
        int end = array.length-1;

        while ( start < end ){

            int middle = start + ( end - start ) / 2;

            if ( array[middle] < array[middle+1] ){
                // This condition means we are still in the increasing part of array
                // and our peak index must be towards the right side
                start = middle + 1;
            }
            else if ( array[middle] > array[middle+1]){
                // We are in the decreasing part of the array
                // This maybe the answer, but we will look further
                end = middle;
            }
        }
        return start;
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
    }
}

