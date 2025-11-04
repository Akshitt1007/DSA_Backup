package g_Recursion.e_Subsets_Permutation_BackTracking;

import java.util.Scanner;

public class c2_Dice_Problem {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );

        System.out.println( "Enter the number: " );
        int target = input.nextInt();

        dice_combo( "", target );

    }

    static void dice_combo( String p, int target ){

        if ( target == 0 ){
            System.out.println( p );
            return ;
        }

        for ( int i=1 ; i <= 6 && i <= target ; i++ ){
            dice_combo( p + i, target-i );
        }
    }

    // Important: when the stack is pop out and goes back to parent call the loop will increment
}
