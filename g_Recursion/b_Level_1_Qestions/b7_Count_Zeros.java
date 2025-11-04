package g_Recursion.b_Level_1_Qestions;

import java.util.Scanner;

public class b7_Count_Zeros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = input.nextInt();

        count( num );
        System.out.println("Using external variable: Number of zeros = " + answer);

        int answerII = countII( num );
        System.out.println("Using helper function: Number of zeros = " + answerII);
    }

    // By external variable
    static int answer = 0;

    static void count ( int num ){

        if( num == 0 ){
            return;
        }

        if ( (num%10) == 0 ){
            answer++;
        }

        count( num/10 );
    }

    // Using a helper function to pass the count as a parameter.
    static int countII(int num){
        return helper( num , 0);
    }
    static int helper ( int num , int c ){

        if ( num == 0 ){
            return c;
            // special example to demonstrate how same value will return to above function calls
        }
        if ( num%10 == 0 ){
            c++;
        }

        return helper( num/10 , c );
    }
}
