package d_Searching.Linear_Search;
import java.util.Scanner;

/*
    Linear Search

    Linear Search is the most basic and straightforward method to search for an element
    in an array or a string of any given length.

    In this approach, we start reading the array from index 0 to (array.length - 1),
    one element at a time, until we find the desired element or reach the end of the array.

    Time Complexity Analysis:
    - Best Case:
        If the desired element is at index 0, we find it in the first comparison.
        The time complexity in this case is O(1).

    - Worst Case:
        If the desired element is not present in the array, we need to traverse the entire array
        of `n` elements to confirm its absence. The time complexity in this case is O(n).

    - Average Case:
        On average, the desired element might be somewhere in the middle of the array.
        The time complexity is approximately O(n/2), but asymptotically, it is still O(n).

    Key Characteristics:
    - Linear Search always involves scanning the entire array if the element is not found.
    - It is simple to implement but not efficient for large datasets.
    - This algorithm does not require the array to be sorted.

    Example:
    If the array length = 100:
    - Best Case: Desired element is at index 0 → Time complexity = O(1).
    - Worst Case: Desired element is not in the array → Time complexity = O(100) or O(n).

    Limitations:
    - Linear Search is not suitable for large datasets because of its high time complexity
      in the worst-case scenario.
    - For better efficiency, other search algorithms like Binary Search (for sorted arrays)
      or Hashing (for direct access) are preferred.
*/


public class a1_Linear_Search {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number to check: ");
        int target = input.nextInt();
        int[] array = {1,2,3,4,5,6,7,8,9};


        // To find the index of target:
        int find_index = Linear_search_index( array , target );

        // Ff the target element exist find_index would not be -1.
        if( find_index == -1 ){
            System.out.println("Element not present ");
        }
        else{
            System.out.println( "Given target is at index: " + find_index );
        }

        // To return the given Target
        int element_return = Linear_search_return_element( array , target );
        if( element_return == Integer.MAX_VALUE ){
            System.out.println("Element not found ");
        }
        else{
            System.out.println("Element found " + element_return );
        }


        // To return True/False
        boolean element_true_false = Linear_search_true_false( array , target );
        if(element_true_false == false ){
            System.out.println("false");
        }
        else{
            System.out.println("true" );
        }

    }

    static int Linear_search_index(int[] array, int target) {

        // Explanation:
        // This function performs a linear search to find the index of the target element in the given array.

        // Edge Case:
        if (array.length == 0) {
            // If the array is empty (length = 0), it means there are no elements to search.
            // Therefore, we immediately return -1 to indicate that the target is not found.
            return -1;
        }

        // Loop through each element of the array
        for (int i = 0; i < array.length; i++) {
            // If the current element matches the target, we return the index of the element.
            // For example, if the target is `1` and it is at index `0`, the loop will terminate early
            // and return `0`, avoiding unnecessary traversal of the remaining array.
            if (array[i] == target) {
                return i;
            }
        }

        // If we reach this point, it means the target element is not found in the array.
        // We have traversed the entire array, and the time complexity for this scenario
        // is O(n), where `n` is the size of the array.
        return -1;
    }



    static int Linear_search_return_element ( int[] array , int target ){
        if ( array.length == 0 ){

            return Integer.MAX_VALUE;
        }

        for( int i = 0 ; i < array.length ; i++ ) {

            if( array[i] == target ){

                return array[i] ;
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean Linear_search_true_false ( int[] array , int target ){
        if ( array.length == 0 ){

            return false;
        }

        for( int i = 0 ; i < array.length ; i++ ) {

            if( array[i] == target ){

                return true;
            }
        }
        return false;
    }
}
