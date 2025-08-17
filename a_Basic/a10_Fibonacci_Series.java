package a_Basics;

import java.util.Scanner;

public class a10_Fibonacci_Series{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = input.nextInt();

        int sum = 0;
        int a = 1;
        int b = 0;

        for(int i=1 ; i<=num ; i++){
            System.out.println(sum);

            sum = a + sum;  // Compute the next Fibonacci number
            b = a;          // Update `b` to the current `a` (track the previous number)
            a = sum;        // Update `a` to the new Fibonacci number
            sum = b;        // Set `sum` back to the value of `b` (track for output)

//            System.out.println(a); // Print the current Fibonacci number here b = 1;
//
//            int sum = a + b; // Calculate the next Fibonacci number
//            a = b; // Update `a` to the next number
//            b = sum; // Update `b` to the next number
        }
    }
}
/*

Iteration	i	sum (printed)	sum = a + sum	b = a	a = sum	    sum = b	   Updated Values (a, b, sum)
1	        1	    0	        1 + 0 = 1	    1	        1	        1	    a = 1, b = 1, sum = 1
2	        2	    1	        1 + 1 = 2	    1	        2	        1	    a = 2, b = 1, sum = 1
3	        3	    1	        2 + 1 = 3	    2	        3	        2	    a = 3, b = 2, sum = 2
4	        4	    2	        3 + 2 = 5	    3	        5	        3	    a = 5, b = 3, sum = 3
5	        5	    3	        5 + 3 = 8	    5	        8	        5	    a = 8, b = 5, sum = 5
6	        6	    5	        8 + 5 = 13	    8	        13	        8	    a = 13, b = 8, sum = 8
7	        7	    8	        13 + 8 = 21	    13	        21	        13	    a = 21, b = 13, sum = 13

 */