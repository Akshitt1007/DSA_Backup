package g_Recursion;

import java.util.Scanner;

public class a2_basic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // In the previous file we have seen that all the method have same body, arguments and return types
        // in such cases instead of writing it again, and again
        // we will call the function itself

        System.out.print("Enter the starting number: ");
        int n = input.nextInt();

        System.out.print("Till where : ");
        int till = input.nextInt();

        number( n , till );

    }

    static void number( int num , int till ){

        if ( num == till ) {
            System.out.println( num );
            return ;
        }

        System.out.println( num );

        // This is the tail recursion.
        // Tail recursion is a specific kind of recursion where the recursive call is the last thing the function does
        // before it returns a result—there’s no further computation after that call.
        number( num + 1 , till );

    }
}
