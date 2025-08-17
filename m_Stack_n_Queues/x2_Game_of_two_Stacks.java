package m_Stack_n_Queues;

//https://www.hackerrank.com/challenges/game-of-two-stacks/problem

// If we simply compare the top elements of both stacks,
// we can get stuck in scenarios like this:

// Stack 1: 6, 1, 1, 1, 1
// Stack 2: 2, 5, 5, 5, 5

// In this case, we can’t progress with Stack 1 because its top element (6)
// is too large, and we keep favoring Stack 2 (since 2 < 6).
// The pointer on Stack 1 remains frozen, blocking potential better outcomes.

// To avoid this kind of deadlock and explore all possible paths,
// we use recursion to simulate **all combinations and permutations**
// of choices—ensuring we don’t miss an optimal path hidden deeper in the stacks.

import java.util.Arrays;
import java.util.Scanner;

public class x2_Game_of_two_Stacks {

    public static int helper(int[] one, int[] two, int sum){
        return predictGame(sum, one, two, 0, 0 )-1 ;
        // Subtracting 1 because we need the total count of numbers used
        // to reach *up to* the given sum—not the point where we’ve already exceeded it.
        // The predictGame function returns the count where the cumulative sum
        // first crosses the target, so we adjust by -1 to reflect the last valid state.
    }

    public static int predictGame(int sum, int[] first, int[] second, int c_sum, int count){

        if( c_sum > sum ){
            return count;
        }
        if ( first.length == 0 || second.length == 0 ){
            return count;
        }

        int left = predictGame(sum, Arrays.copyOfRange(first, 1, first.length), second, c_sum + first[0], count + 1);
        int right = predictGame(sum, first, Arrays.copyOfRange(second, 1, second.length),  c_sum + second[0], count + 1);

        if ( left > right ){
            return left;
        }
        else{
            return right;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int x = s.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int j = 0; j < n; j++) {
                a[j] = s.nextInt();
            }
            for (int j = 0; j < m; j++) {
                b[j] = s.nextInt();
            }
            System.out.println(helper( a, b, x));
        }
        /*
        1           <- number of testcase
        5 4 10      <- elements in stack 1 and stack2 and given sum
        4 2 4 6 1   <- Values of stack 1
        2 1 8 5     <- Value of stack 2
         */
    }
}
