package d_Searching.Binary_Search;
    /*
     Binary search - O(log n)

     Why it is O(log n) ?

     If 𝑛 = 16 n=16: 16 → 8 → 4 → 2 → 1 16→8→4→2→1, which takes 4 steps (i.e., log  2 ( 16 ) = 4 log 2  (16)=4).
     If 𝑛 = 32 n=32: 32 → 16 → 8 → 4 → 2 → 1 32→16→8→4→2→1, which takes 5 steps (i.e., log  2 ( 32 ) = 5 log 2  (32)=5).

    Best Case:
        Scenario: The target element is at the middle index in the first comparison.
        Steps: Only one comparison is needed.
        Time Complexity: O(1).
    Worst Case:
        Scenario: The target element is not in the array, or it is located at the far ends (first or last index).
        Steps: At each step, the search space is halved. In the worst case, the number of steps required is proportional to the logarithm of the array size.
        Time Complexity: O(log n), where n is the number of elements in the array


     This type of algorithm is always used in a MONOTONIC FUNCTION (sorted array) to find a specific key .
     Approach:
        1. Start with the entire array (start = 0, end = array.length - 1).
        2. Calculate the middle index: middle = (start + end) / 2.
        3. Compare the middle element with the target:
        4. If the middle element matches the target, return its index.
        5. If the target is smaller, search the left half (end = middle - 1).
        6. If the target is larger, search the right half (start = middle + 1).
        7. Repeat the process until the target is found or the search space becomes empty (start > end).


     for example :

     int arr[5]={3,5,9,13,27};
     key=13.

     1. first we will find the middle number according to which we will check for our key
     2. here the middle number is 5/2=2 so it is 9
     3. then if 9==13 that is not so we know that our key is not the middle key
     4. now we will check whether our key is greater our less than the middle number
     5. here 13>9 so will check for number next to middle number arr[middle]->arr[n-1]
     6. so our new middle number would be =(starting+ending)/2
     7. here it is (3+4)/2==3 adn element on 3 is 13
     8. now we will check key with this
     9. 13==13 that is true, and we return index[3]


     example:

     arr[5]={4,8,16,22,34};
     key =4

     1. mid=(0+4)/2 =2 element of 2 is 16
     2. 4 != 16
     3. and 4<16
     4. so we will check for left part
     5. arr[]={4,8}
     6. mid=(0+1)/2=0 element of 0 is 4
     7. and 4==4 and return index[0].

     */


import java.util.Scanner;

public class b1_Binary_Search {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

//        int [] array = { 11,34,56,90,91,92,93,95,99,100,101};
        int [] array = {3,1};

        System.out.println("Enter the target element: ");
        int target = s1.nextInt();

        int index = find_index(array , target);

        if(index == -1){
            System.out.println("Target not present" );
        }
        else{
            System.out.println("Target at index: " + index);
        }
    }

    static int find_index(int [] array , int target ){
        int start = 0;
        int end = array.length-1;

//        for(int i = start ; i <= end ; i++ ){
        while( start <= end ){

            int middle = (start+end)/2;
            // To find the middle element
            // and making our array short by comparing it with the target element

            if(array[middle] == target){
                return middle;
                // if the target element is at the middle only then it will return middle element
            }
            else if( target > array[middle] ){
                start = middle+1;
                // if the target element is at greater than middle
                // then we don't have to search it in left side of middle since they all also be less than middle because of sorted array,
                // and we will change the start to middle + 1
            }
            else{
                end = middle - 1;
                // if the target element is at less than middle
                // then we don't have to search it in right side of middle since they all also be greater than middle because of sorted array,
                // and we will change the end to middle - 1
            }
        }
        return -1;
        // If the loop ends, the target is not in the array
    }
}

    /*
     Imagine we have:

     start = 2,000,000,000
     end = 2,147,483,600

     Using (start + end) / 2:

     1. start + end = 2,000,000,000 + 2,147,483,600 = 4,147,483,600
     2. This value 4,147,483,600 exceeds the maximum integer limit of 2,147,483,647, causing an integer overflow.
     3. Overflow may result in an unexpected negative value, causing errors in your program.

     Using start + (end - start) / 2:

     1. calculate (end - start) = 2,147,483,600 - 2,000,000,000 = 147,483,600
     2. Then, divide by 2: (end - start) / 2 = 147,483,600 / 2 = 73,741,800
     3. Add this to start: start + 73,741,800 = 2,000,000,000 + 73,741,800 = 2,073,741,800
     4. we avoided overflow by performing safe operations, and mid is correctly calculated as 2,073,741,800, which is within the integer range.

     */
