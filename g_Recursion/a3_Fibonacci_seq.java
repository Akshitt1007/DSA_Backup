package g_Recursion;

import java.util.Scanner;

public class a3_Fibonacci_seq {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the nth number: ");
        int nth = input.nextInt();

        int answer = fib_recursion(nth);

        System.out.println( "Your nth number is: " + answer );
    }

    static int fib_recursion( int n ){

//        if ( n == 0 ){
//            return 0;
//        }
//        if ( n == 1){
//            return 1;
//        }

        if ( n < 2 ){
            return n;
        }

        // This is not a tail recursion
        // first fib(n-1) will run
        // then fib(n-2) will run
        // in the last return fib(n-1) + fib(n-2) will run
        // these extra steps is not the tail recursion
        return fib_recursion( n-1 ) + fib_recursion( n-2 );
    }
}
