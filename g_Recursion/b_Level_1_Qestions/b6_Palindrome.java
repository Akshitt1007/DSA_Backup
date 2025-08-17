package g_Recursion.b_Level_1_Qestions;

import java.util.Scanner;

public class b6_Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number to check: ");
        int num = input.nextInt();

        palindrome( num );

        if ( num == chck ) System.out.println( "Yes");
        else System.out.println( "No");
    }

    static int chck = 0;

    static void palindrome ( int num ){

        if ( num == 0 ){
            return ;
        }

        int ld = num % 10;
        chck = chck*10 + ld;

        palindrome( num/10 );
    }
}
