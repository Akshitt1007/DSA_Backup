package c_Arrays;
import java.util.Scanner;

/*
Problem 3: Sum of Multiples of 6 or 10

Given a positive number y, find the sum of all multiples of 6 or 10 less than or equal to y.
Example: If y=30, the multiples are 6, 10, 12, 18, 20, 24, and 30. Sum = 120.

 */
public class x13_Sum_of_Multiples {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = in.nextInt();

        int sum = 0;
        for ( int i=1 ; i<= num ; i++ ){
            if ( i % 6 == 0 || i % 10 == 0 ){
                sum = sum + i;
            }
        }
        System.out.println( sum );
    }
}
