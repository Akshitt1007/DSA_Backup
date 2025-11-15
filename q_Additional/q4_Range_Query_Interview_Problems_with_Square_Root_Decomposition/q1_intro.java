package q_Additional.q4_Range_Query_Interview_Problems_with_Square_Root_Decomposition;

/*
    - To find the sum (or any query) between two indexes L → R,
      the basic method is to simply traverse from L to R.

            Index : 0 1 2 3 4 5 6 7 8 9
            Array : 1 2 3 4 5 6 7 8 9 10

      Example: sum from index 3 → 8

    - Time Complexity:
            Worst Case  : O(n)
            Best Case   : O(1)       (when L == R)

    - But when multiple queries come in,
      doing this for each query becomes slow.

      Therefore, we use a more optimized method:

    --------------------------------------------------------------
                        ** MO'S ALGORITHM **
    --------------------------------------------------------------

    - Purpose:
            To answer multiple range queries efficiently
            on a STATIC array (no updates).
            reduce the tc to root n

    - Steps:
            1. Divide the array into block of size /n (root n)
            2. compute answer for every block
            3. Given a query from Left to Right, combine the answer from both blocks

    - Example:
            - arr = [ 1, 3, 5, 2, 7, 6, 3, 1, 4, 8 ]

            1. We will divide the whole array into further small sub array
            2. We will divide the array in root/n ( if n = 9 and root = 3), we will divide the sub array such tha every sub array have 3 elements in it
            3, If there are any elements left we will add 0 to fill that sub array
            4. after the sub array we will solve the sub array according to given query

            - n = arr.length() => 9 and root/9 = 3

            - arr = [1, 3, 5] [2, 7, 6] [3, 1, 4] [8, 0, 0]

            - we have to find the sum therefore we added the all element in their given subarray.

            - arr = [9, 15, 8, 8 ]

            6. There could be 3 cases
                1. Fully Inside:
                       - Query lies completely inside the middle subarray.
                         Example: middle = [3,4,5], range = 3–5

                    2. Extends One Side:
                       - Query overlaps and extends either left or right.
                         Example: 2–5 (extend left), 3–6 (extend right)

                    3. Extends Both Sides:
                       - Query needs elements before and after the middle subarray.
                         Example: middle = [2,7,6], range = 1–7

    - Working:
                      0  1  2  3  4  5  6  7  8  9
            - arr = [ 1, 3, 5, 2, 7, 6, 3, 1, 4, 8 ]

                      0  1   2   3
            - arr = [ 9, 15, 8, 8]


*/

public class q1_intro {
    public static void main(String[] args) {

    }
}
